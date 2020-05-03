DELIMITER //
CREATE PROCEDURE SP_GetCompradoresPorNome(termo varchar(100))
BEGIN
	SELECT * FROM comprador WHERE nome like termo;
END //
DELIMITER ;

Call devdojo.SP_GetCompradoresPorNome('%%'); 

