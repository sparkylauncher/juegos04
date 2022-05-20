CREATE TABLE FABRICANTES(

		CODIGO				INTEGER				NOT NULL,
		NOMBRE				VARCHAR(200)		,
		
		PRIMARY KEY(CODIGO)
		
);

CREATE TABLE VIDEOJUEGOS(

		CODIGO				VARCHAR(20)			NOT NULL,
		TITULO				VARCHAR(200)			,
		FECHA_ALTA			DATE				,
		PRECIO				DOUBLE				,
		DESCATALOGADO		BOOLEAN				,
		TIPO_VIDEOJUEGO		VARCHAR(100)		,
		ID_FABRICANTE		INTEGER				,
		
		PRIMARY KEY(CODIGO)						,
		FOREIGN KEY (ID_FABRICANTE) REFERENCES FABRICANTES (CODIGO)

);