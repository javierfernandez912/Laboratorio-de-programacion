<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes" />
    <xsl:template match="/">
        <html>
            <head>
                <title>Calificaciones - <xsl:value-of select="calificaciones/@fecha" />
                </title>
            </head>
            <body>
                <h2>Calificaciones del dia <xsl:value-of select="calificaciones/@fecha" /></h2>
                <table>
                    <tr>
                        <th>Nombre</th>
                        <th>Materia</th>
                        <th>Nota</th>
                    </tr>
                    <xsl:for-each select="calificaciones/alumno">
                        <xsl:sort select="nota" data-type="number" order="descending" />
                        <tr>
                            <xsl:attribute name="style">
                                <xsl:choose>
                                    <xsl:when test="nota &gt; 70">background-color: green;</xsl:when>
                                    <xsl:when test="nota &gt;= 40">background-color: yellow;</xsl:when>
                                    <xsl:otherwise>background-color: red;</xsl:otherwise>
                                </xsl:choose>
                            </xsl:attribute>
                            <td>
                                <xsl:value-of select="nombre" />
                                <xsl:if test="@tipo='recursante'">
                                    <span>*</span>
                                </xsl:if>
                            </td>
                            <td>
                                <xsl:value-of select="materia" />
                            </td>
                            <td>
                                <xsl:value-of select="nota" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
                <p>*El alumno es recursante.</p>
                <p>Total de alumnos: <xsl:value-of select="count(calificaciones/alumno)" /></p>
                <p>Alumnos aprobados: <xsl:value-of select="count(calificaciones/alumno[nota &gt; 70])" /></p>
                <p>Alumnos desaprobados: <xsl:value-of select="count(calificaciones/alumno[nota &lt;= 70])" /></p>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>