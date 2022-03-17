
create table if not exists Myfile (
	idfile integer primary key autoincrement,
	name text, 
	path  text, 
	type text,
	idcategory integer, 
	foreign key(idcategory) references MyCategory(idcat)
	on delete set null
);

create table if not exists MyCategory (
	idcat integer primary key autoincrement, 
	title text, 
	description text
);