-- cms_recipe_step_info definition
create table cms_recipe_step_info
(
    F_ID                    bigint auto_increment comment 'ID' primary key,
    F_RECIPE_ID              bigint          not null comment 'Recipe number',
    F_STEP_IMG_URL           varchar(128)    not null comment 'Food images for recipes',
    F_STEP_CONTENT           varchar(512)    not null comment 'Step descriptions for recipes',
    F_STEP_ORDER             char(3)         not null comment 'Step orders',
    F_UPDATE_DATE            varchar(14)     not null comment 'Record updated date',
    F_CREATED_DATE           varchar(14)     not null comment 'Record created date'
)
    comment 'Recipe steps table' charset = utf8;

create index idx_f_recipe_id
    on cms_recipe_step_info (F_RECIPE_ID);

