<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <head>
                <title>Gestion de Libros</title>
            </head>
            <body>
                <h2>Gestion de Libros</h2>
                <h1>LIBROS DISPONIBLES</h1>
                <p>Total de libros disponibles: <xsl:value-of select="count(gestionLibros/librosdig)" />
                </p>
                <table>
                    <tr>
                        <th>Titulo</th>
                        <th>Autor</th>
                        <th>Editorial</th>
                        <th>Año de edicion</th>
                        <th>Género</th>
                    </tr>
                    <xsl:for-each select="gestionLibros/librosdig">
                        <xsl:sort select="titulo" data-type="text" order="ascending" />
                        <tr>
                            <td>
                                <xsl:value-of select="titulo" />
                            </td>
                            <td>
                                <xsl:value-of select="autor" />
                            </td>
                            <td>
                                <xsl:value-of select="editorial" />
                            </td>
                            <td>
                                <xsl:value-of select="año_edicion" />
                            </td>
                            <td>
                                <xsl:variable name="idDelLibro" select="genero_id" />
                                <xsl:value-of select="/gestionLibros/generos[@id = $idDelLibro]/nombre" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <p>En esta biblioteca almacenamos libros de <xsl:value-of select="count(gestionLibros/generos)" /> generos distintos, los cuales son:</p>
                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>Cantidad de libros</th>
                    </tr>
                    <xsl:for-each select="gestionLibros/generos">
                        <xsl:sort select="nombre" data-type="text" order="ascending" />
                        <tr>
                            <td>
                                <xsl:value-of select="nombre" />
                            </td>
                            <td>
                                <xsl:variable name="id" select="@id" />
                                <xsl:value-of select="count(/gestionLibros/librosdig[genero_id = $id])" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>