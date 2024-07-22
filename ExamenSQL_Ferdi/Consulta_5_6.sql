SELECT titulo
FROM libros
WHERE anyo = (SELECT MIN(anyo) FROM libros);