<?xml version="1.0"?><xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">	<xsl:output method="html" indent="yes" omit-xml-declaration="yes"/>	<xsl:param name="min"/>	<xsl:param name="max"/>	<xsl:template match="CLRCMetadata">		<xsl:choose>			<xsl:when test="MetadataRecord">				<table border="0" width="95%" align="center" cellspacing="0" cellpadding="1" bgcolor="#FFFFFF">					<!--	<thead>						<tr>							<th>Study Name</th>							<th>Facility</th>							<th>Owner</th>							<th>Institution</th>							<th>Date</th>							<th>Select</th>						</tr>					</thead>-->					<tbody>						<xsl:apply-templates select="MetadataRecord[position()&gt;$min and position()&lt;=$max]">							<xsl:sort select="@facility"/>						</xsl:apply-templates>					</tbody>					<tr>						<td>				<input type="submit" value="Expand selected studies" name="this_one" />    </td><td>             <input type="submit" value="View selected studies datasets" name="this_one" /></td>					</tr>				</table>			</xsl:when>			<xsl:otherwise>				<h2>No records found which satisfy query.</h2>			</xsl:otherwise>		</xsl:choose>	</xsl:template>	<xsl:template match="MetadataRecord">		<tr bgcolor="#ADD8E6">			<td colspan="4">				<b>					<font size="4">						<xsl:apply-templates select="*/StudyName"/>					</font>				</b>			</td>		</tr>		<tr bgcolor="#ADD8E6">			<td colspan="1">				<i>Institution:    </i>				<xsl:apply-templates select="*/Investigator[1]/Institution"/>			</td>			<td align="right">Select Study: 				<input type="checkbox" name="select" style="cursor:crosshair;">					<xsl:attribute name="value"><xsl:value-of select="@metadataID"/></xsl:attribute>					<xsl:if test="@expand">						<xsl:attribute name="checked"/>					</xsl:if>				</input>			</td>			<td width="20">				<xsl:text> </xsl:text>			</td>		</tr>		<tr bgcolor="#ADD8E6">			<td colspan="4">				<i>	PI:     </i>				<xsl:apply-templates select="*/Investigator[1]/Name"/>			</td>		</tr>		<tr bgcolor="#ADD8E6">			<td colspan="4">				<i>Start date:      </i>				<xsl:apply-templates select="*/StudyInformation/TimePeriod"/>			</td>		</tr>		<tr>			<td>				<br/>			</td>		</tr>		<tr>			<td colspan="4">				<xsl:value-of select="substring(*/StudyInformation/Purpose/Abstract,1,400)"/>			</td>		</tr>		<tr>			<td>				<br/>							</td>		</tr>	</xsl:template>	<xsl:template match="StudyName">		<xsl:value-of select="."/>	</xsl:template>	<xsl:template match="Investigator/Name">		<xsl:if test="PersonTitle">			<xsl:value-of select="PersonTitle"/>			<xsl:text> </xsl:text>		</xsl:if>		<xsl:if test="Initials">			<xsl:value-of select="Initials"/>			<xsl:text> </xsl:text>		</xsl:if>		<xsl:value-of select="Surname"/>	</xsl:template>	<xsl:template match="Institution">		<xsl:value-of select="."/>	</xsl:template>	<xsl:template match="TimePeriod">		<xsl:apply-templates select="StartDate"/>	</xsl:template>	<xsl:template match="StartDate">		<xsl:apply-templates select="Date"/>	</xsl:template></xsl:stylesheet>