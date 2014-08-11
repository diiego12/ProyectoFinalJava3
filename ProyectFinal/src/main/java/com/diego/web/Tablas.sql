CREATE TABLE discografica(id_discografica integer primary key auto_increment,
                    nombre varchar(50),pais varchar(50));


CREATE TABLE banda(id_banda integer primary key auto_increment,
		discografica integer,
                nombre varchar(80),
		pais varchar(80),
		foreign key(discografica) references discografica(id_discografica));


CREATE TABLE disco(id_disco integer primary key auto_increment,
		id_banda integer,
    		titulo varchar(80),
		banda varchar(80),
		año integer,
                foreign key(id_banda) references banda(id_banda));
