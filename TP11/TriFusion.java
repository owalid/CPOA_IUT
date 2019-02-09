import java.util.*;
import java.util.concurrent.*;

public class TriFusion {
	public static void main(String[] args) throws Exception {
		System.out.println(tri(intList(new int[]{1, 5, 4, 3, 2})));
	}

	private static List<Integer> intList(int[] ints) {
		List<Integer> res = new LinkedList<Integer>();;

		for(int i = 0;  i < ints.length; ++i)
			res.add(new Integer(ints[i]));

		return res;
	}

	public static <E extends Comparable<E>> List<E> tri(List<E> list) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();

		TriWorker<E> worker = new TriWorker<E>(list, exec);
		List<E> res = exec.submit(worker).get();

		exec.shutdown();
		
		return res;
	}

	private static class TriWorker<E extends Comparable<E>> implements Callable<List<E>> {
		private List<E> list;
		private ExecutorService exec;

		public TriWorker(List<E> list, ExecutorService exec) {
			this.list = list;
			this.exec = exec;
		}

		@Override
		public List<E> call() throws Exception {
			if(list.size() < 2)
				return list;

			TriWorker<E> listWorker1 = new TriWorker<E>(list.subList(0, list.size()/2), exec);
			TriWorker<E> listWorker2 = new TriWorker<E>(list.subList(list.size()/2, list.size()), exec);

			Future<List<E>> listFuture1 = exec.submit(listWorker1);
			Future<List<E>> listFuture2 = exec.submit(listWorker2);

			List<E> list1 = listFuture1.get();
			List<E> list2 = listFuture2.get();

			List<E> res = new LinkedList<E>();

			Iterator<E> iter1 = list1.iterator();
			Iterator<E> iter2 = list2.iterator();

			E first1 = iter1.next();
			E first2 = iter2.next();

			while(first1 != null || first2 != null) {
				if((first1 != null && first2 != null && first1.compareTo(first2) <= 0) || first2 == null) {
					res.add(first1);
					first1 = iter1.hasNext() ? iter1.next() : null;
				} else {
					res.add(first2);
					first2 = iter2.hasNext() ? iter2.next() : null;
				}
			}

			return res;
		}
	}
}
