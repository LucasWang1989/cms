-- cms_recipe_info definition
create table cms_recipe_info
(
    F_ID                    bigint auto_increment comment 'ID' primary key,
    F_TITLE                  varchar(128)    not null comment 'Title',
    F_INTRO                  varchar(512)    not null comment 'Introductions of this recipe',
    F_INGREDIENTS            varchar(512)    not null comment 'Ingredients of this recipe',
    F_SUB_INGREDIENTS        varchar(512)    null comment 'Sub ingredients of this recipe',
    F_COVER_PAGE_URL         varchar(128)    not null comment 'The url from recipe cover images',
    F_COVER_VIDEO_URL        varchar(128)    not null comment 'The url from recipe cover videos',
    F_MEDIA_TYPE             char(1)         not null comment 'Media type: 0-Image; 1-Video.',
    F_USER_NAME              varchar(128)    not null comment 'User name',
    F_UPDATE_DATE            varchar(14)     not null comment 'Record updated date',
    F_CREATED_DATE           varchar(14)     not null comment 'Record created date'
)
    comment 'Recipe table' charset = utf8;

create index idx_f_update_date
    on cms_recipe_info (F_UPDATE_DATE);

