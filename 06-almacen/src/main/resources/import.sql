insert into Autor (nombre) values ('Paulo Silveira') 
insert into Autor (nombre) values ('Adriano Almeida')
insert into Autor (nombre) values ('Vinicius Baggio Fuentes')

insert into Libro (anoDePublicacion,editora,nombre,resumen) values (2012,'Casa do Código','Guia do Programador','Vá do "nunca programei"...')
insert into Libro (anoDePublicacion,editora,nombre,resumen) values (2012,'Casa do Código','Ruby on Rails','Crie rapidamente aplicações web')

insert into Libro_Autor (libro_id,autores_id) values (1,1)
insert into Libro_Autor (libro_id,autores_id) values (1,2)
insert into Libro_Autor (libro_id,autores_id) values (2,3)