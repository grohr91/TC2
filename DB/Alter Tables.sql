/*SET SQL_SAFE_UPDATES = 0;
delete from individuo;
delete from grupo;

alter table individuo DROP PRIMARY KEY,
   change id_individuo id_individuo int(11) NOT NULL,
   add PRIMARY KEY(id_individuo);
alter table grupo DROP PRIMARY KEY,
   change id_grupo id_grupo int(11) NOT NULL,
   add PRIMARY KEY(id_grupo);
alter table desafio DROP PRIMARY KEY,
   change id_desafio id_desafio int(11) NOT NULL,
   add PRIMARY KEY(id_desafio);
*/

select * from individuo