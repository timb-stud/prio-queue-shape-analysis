j2tvla-all: j2tvla-sorted j2tvla-unsorted

j2tvla-sorted: bin/J2tvlaSorted.class
	cd bin; j2tvla J2tvlaSorted

j2tvla-unsorted: bin/J2tvlaUnsorted.class
	cd bin; j2tvla J2tvlaUnsorted
