DELIMITER //

CREATE TRIGGER before_insert_licencia
BEFORE INSERT ON licencias
FOR EACH ROW
BEGIN
    DECLARE licencia_activa INT;
    SELECT COUNT(*) INTO licencia_activa 
    FROM licencias 
    WHERE persona_id = NEW.persona_id AND estado = "Activa";
    IF licencia_activa> 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Esta persona ya tiene una licencia activa, no se puede agregar otra.';
    END IF;
END//

DELIMITER ;