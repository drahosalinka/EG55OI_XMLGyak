<!-- kurzusfelvetelEG55OI.xsl -->

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

  <xsl:template match="/">
    <html>
      <head>
        <style>
          table {
            border-collapse: collapse;
            width: 100%;
          }

          th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
          }

          th {
            background-color: #f2f2f2;
          }
        </style>
      </head>
      <body>
        <h2>Kurzusfelvétel</h2>
        <h3>Tanev: <xsl:value-of select="/EG55OI_kurzusfelvetel/@tanev"/></h3>
        <h3>Egyetem: <xsl:value-of select="/EG55OI_kurzusfelvetel/@egyetem"/></h3>
        
        <h3>Hallgató információ:</h3>
        <table>
          <tr>
            <th>Név</th>
            <th>Születési év</th>
            <th>Szak</th>
          </tr>
          <xsl:for-each select="/EG55OI_kurzusfelvetel/hallgato">
            <tr>
              <td><xsl:value-of select="hnev"/></td>
              <td><xsl:value-of select="szulev"/></td>
              <td><xsl:value-of select="szak"/></td>
            </tr>
          </xsl:for-each>
        </table>
        
        <h3>Kurzusok:</h3>
        <table>
          <tr>
            <th>Kurzusnév</th>
            <th>Kredit</th>
            <th>Hely</th>
            <th>Időpont</th>
            <th>Oktató/Oraadó</th>
          </tr>
          <xsl:for-each select="/EG55OI_kurzusfelvetel/kurzusok/kurzus">
            <tr>
              <td><xsl:value-of select="kurzusnev"/></td>
              <td><xsl:value-of select="kredit"/></td>
              <td><xsl:value-of select="hely"/></td>
              <td><xsl:value-of select="idopont"/></td>
              <td>
                <xsl:choose>
                  <xsl:when test="oraado">
                    <xsl:value-of select="oraado"/>
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:value-of select="oktato"/>
                  </xsl:otherwise>
                </xsl:choose>
              </td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>
