-- auto-generated definition
create table cms_recipe_category_relation
(
    F_ID                    bigint auto_increment comment 'ID' primary key,
    F_RECIPE_ID              bigint          not null comment 'Recipe id',
    F_CATEGORY_ID            bigint          not null comment 'Category id',
    F_UPDATE_DATE            varchar(14)     not null comment 'Record updated date',
    F_CREATED_DATE           varchar(14)     not null comment 'Record created date'
)
    comment 'Table of relationship between recipes and categories' charset = utf8;