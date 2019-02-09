#include "FileVoitures.h"
#include "Voiture.h"

#include <iostream>
#include <iterator>
#include <algorithm>

std::ostream& operator<<(std::ostream &os, const FileVoitures &f) {
	os << "File de voitures :\n";

	for(std::list<Voiture>::const_iterator it = f.liste.begin(); it != f.liste.end(); ++it) {
		os << *it << "\n";
	}

	return os;
}

void FileVoitures::ajouter(const Voiture &v) {
	liste.push_back(v);
}

void FileVoitures::supprimer() {
	liste.pop_front();
}

bool FileVoitures::chercher(const Voiture &v) const {
	return std::find(liste.begin(), liste.end(), v) != liste.end();
}
