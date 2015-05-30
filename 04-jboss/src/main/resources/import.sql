insert into Autor (nome) values ('Max Alvarez') 
insert into Autor (nome) values ('Juan Perez')
insert into Autor (nome) values ('Daniel Orihuela')

insert into Libro (anoDePublicacion,editora,nombre,resumen) values (2012,'Peru Jug','Guia del Programador','La biblia del programador"...')
insert into Libro (anoDePublicacion,editora,nombre,resumen) values (2012,'Ruby Peru','Ruby on Rails','Construya rapidamente aplicaciones web')

insert into Libro_Autor (libro_id,autores_id) values (1,1)
insert into Libro_Autor (libro_id,autores_id) values (1,2)
insert into Libro_Autor (libro_id,autores_id) values (2,3)