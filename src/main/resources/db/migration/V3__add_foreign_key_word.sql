ALTER TABLE `assignment`.`word`
ADD COLUMN `source_id` BIGINT NOT NULL AFTER `negative_count`,
ADD INDEX `FK_source_idx` (`source_id` ASC) VISIBLE;

ALTER TABLE `assignment`.`word`
ADD CONSTRAINT `FK_source`
  FOREIGN KEY (`source_id`)
  REFERENCES `assignment`.`source` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
