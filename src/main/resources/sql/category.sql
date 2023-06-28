-- auto-generated definition
create table cms_recipe_category_info
(
    F_ID                    bigint auto_increment   comment 'ID' primary key,
    F_NAME                  varchar(64)     not null comment 'Category name',
    F_UPDATE_DATE           varchar(14)     not null comment 'Record updated date',
    F_CREATED_DATE          varchar(14)     not null comment 'Record created date'
)
    comment 'Categories of recipes table' charset = utf8;



insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Chinese', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Indonesia', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Indian', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Breakfast', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Lunch', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Dinner', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Dessert', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Drinks', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Snacks', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Meat', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Salads', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Seafood', '20230525165800', '20230525165800');
insert into cms_recipe_category_info(F_NAME,F_UPDATE_DATE,F_CREATED_DATE) values ('Sweet', '20230525165800', '20230525165800');



