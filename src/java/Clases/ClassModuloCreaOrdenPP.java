package Clases;

public class ClassModuloCreaOrdenPP {
    int c;
    int d;

    public String imprimirTablaOperacionesPP() {
        String html;
        html = "<table class=\"TablaCont\" id=\"TablaOperaciones\" disabled=\"true\">\n"
                + "        <thead>\n"
                + "                <tr id=\"CabeceraTabla\">\n"
                + "                    <td>&nbsp;&nbsp;&nbsp;</td>\n"
                + "                    <td>Operacion</td>\n"
                + "                    <td>Puesto/Trabajo</td>\n"
                + "                    <td>Centro</td>\n"
                + "                    <td>Status</td>\n"
                + "                    <td>Clave de Operación</td>\n"
                + "                    <td>Descripcion de Operación</td>\n"
                //                + "                    <td>Tiempo total</td>\n"
                + "                    <td>Cantidad</td>\n"
                + "                    <td>Duracion</td>\n"
                + "                    <td>UMD</td>\n"
                + "\n"
                + "                </tr>\n"
                + "        </thead>\n"
                + "        <tbody id=\"cargarDatosTabOpe\">";
        for (c = 0; c <= 10; c++) {
            html += "<tr>\n"
                    + "                <td><input type=\"checkbox\" style=\"size: 100%;\" name=\"TOpos\" value=" + c + "></td>\n"
                    + "                <td><input type=\"text\" name=\"TOope\" id=\"TOope" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 55px;\" readonly></td>\n"
                    + "                <td><input type=\"text\" name=\"TOptoTr\" id=\"TOptoTr" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOptoTr')\" style=\"width: 105px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">     <button id=\"match_TOptoTr" + c + "\" name=\"match_TOptoTr\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTOPtoTr('" + c + "')\"></button> </td>\n"
                    + "                <td><input type=\"text\" name=\"TOcent\" id=\"TOcent" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOcent')\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">       <button id=\"match_TOcent" + c + "\" name=\"match_TOcent\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOCent('" + c + "')\"></button></td>\n"
                    + "                <td><input type=\"text\" name=\"TOclvOpe\" id=\"TOclvOpe" + c + "\" onfocus=\"BtnHideTO()\"style=\"width: 75px;\" disabled></td>\n"
                    + "                <td><input type=\"text\" name=\"TOsta\" id=\"TOsta" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOsta')\" value=\"\" style=\"width: 120px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">         <button id=\"match_TOsta" + c + "\" name=\"match_TOsta\" class='BtnMatchIcon'  style=\"display : none;\" onclick=\"matchTOSta('" + c + "')\"></button></td>\n"
                    + "                <td><input type=\"text\" name=\"TOdesOpe\" id=\"TOdesOpe" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOdesOpe')\" style=\"width: 415px;\" maxlength=\"40\">                                                            <button id=\"match_TOdesOpe" + c + "\" name=\"match_TOdesOpe\" class='BtnMatchIconDescri'  style=\"display : none;\" onclick=\"mostrarVentanaModalib()\"></button>     </td>\n"
                    //                    + "                <td><input type=\"text\" name=\"TOtiemReal\" id=\"TOtiemReal" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 100px;\" disabled></td>\n"
                    + "                <td><input type=\"text\" name=\"TOcant\" id=\"TOcant" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 95px;\" maxlength=\"13\"></td>\n"
                    + "                <td><input type=\"text\" name=\"TOdura\" id=\"TOdura" + c + "\" onfocus=\"BtnHideTO()\" style=\"width: 65px;\" maxlength=\"5\" ></td>\n"
                    + "                <td><input type=\"text\" name=\"TOumd\" id=\"TOumd" + c + "\" onfocus=\"BtnShowTO('" + c + "','match_TOumd')\" maxlength=\"3\" style=\"width: 65px;\" onKeyUp=\"this.value = this.value.toUpperCase();\"  >     <button id=\"match_TOumd" + c + "\" name=\"match_TOumd\" class='BtnMatchIcon'  style=\"display :none  ;\" onclick=\"matchTOUMD('" + c + "')\"></button></td>\n"
                    + "                <td style=\"visibility: hidden;\"><input type=\"text\" name=\"TOcont\" id=\"TOcont" + c + "\">     </td>\n"
                    + "           </tr>";
        }
        html += "</tbody>"
                + "          </table>";
        return html;
    }

    public String imprimirTablaComponentesPP() {
        String html;
        html = "<table class=\"TablaCont\" id=\"TablaComponentes\">\n"
                + "        <thead>\n"
                + "                <tr id=\"CabeceraTabla\">\n"
                + "                    <td>&nbsp;&nbsp;&nbsp;</td>\n"
                + "                    <td>Material</td>\n"
                + "                    <td>Lote</td>\n"
                + "                    <td>Texto Breve de Material</td>\n"
                + "                    <td>Cantidad</td>\n"
                + "                    <td>UMC</td>\n"
                + "                    <td>Centro</td>\n"
                + "                    <td>Almacén</td>\n"
                + "                    <td>Operación</td>\n"
                + "                    <td>Sol.P.</td>\n"
                + "                    <td>ItemSol.P</td>\n"
                + "\n"
                + "                </tr>\n"
                + "        </thead>\n"
                + "        <tbody id=\"cargarDatosTabComp\">";
        for (d = 0; d <= 10; d++) {
            html += "<tr>\n"
                    + "                <td><input type=\"checkbox\" style=\"size: 100%;\" id=\"TCpos" + d + "\" name=\"TCpos\" value=" + d + "></td>\n"
                    + "                <td><input type=\"text\" name=\"TCmat\" id=\"TCmat" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCmat')\" style=\"width: 225px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"18\">     <button id=\"match_TCmat" + d + "\" name=\"match_TCmat\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCmat('" + d + "')\"></button></td>\n"
                    + "                <td><input type=\"text\" name=\"TClot\" id=\"TClot" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TClot')\" style=\"width: 45px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"10\">     <button id=\"match_TClot" + d + "\"  class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTClot('" + d + "')\"></button></td>\n"
                    + "                <td><input type=\"text\" name=\"TCtxtB\" id=\"TCtxtB" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 325px;\" maxlength=\"40\"></td>\n"
                    + "                <td><input type=\"text\" name=\"TCcant\" id=\"TCcant" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 95px;\" onblur=\"this.value = checkDecCant1(this.value, 3, 'serCtdOp2')\"   onKeyUp=\"this.value = check99(this.value, '9999999', 7)\" maxlength=\"11\"></td>\n"
                    + "                <td><input type=\"text\" name=\"TCumc\" id=\"TCumc" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCumc')\" style=\"width: 55px;\" onblur=\"checkDecCant2('TCcant" + d + "', 'TCumc" + d + "');\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"3\">      <button id=\"match_TCumc" + d + "\" name=\"match_TCumc\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCUMC('" + d + "')\"></button></td>\n"
                    + "                <td><input type=\"text\" name=\"TCcent\" id=\"TCcent" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCcent')\" style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">   <button id=\"match_TCcent" + d + "\" name=\"match_TCcent\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCcent('" + d + "')\"></button></td>\n"
                    + "                <td><input type=\"text\" name=\"TCalm\" id=\"TCalm" + d + "\" onfocus=\"BtnShowTC('" + d + "','match_TCalm')\" style=\"width: 55px;\" onKeyUp=\"this.value = this.value.toUpperCase();\" maxlength=\"4\">      <button id=\"match_TCalm" + d + "\" name=\"match_TCalm\" class='BtnMatchIcon'  style=\"display :none;\" onclick=\"matchTCalm('" + d + "')\"></button></td>\n"
                    + "                <td><input type=\"text\" name=\"TCope\" id=\"TCope" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 55px;\" maxlength=\"4\"></td>\n"
                    + "                <td><input type=\"text\" name=\"TCsolp\" id=\"TCsolp" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 75px;\" disabled></td>\n"
                    + "                <td><input type=\"text\" name=\"TCitsol\" id=\"TCitsol" + d + "\" onfocus=\"BtnHideTC()\" style=\"width: 65px;\" disabled></td>\n"
                    + "           </tr>";
        }
        html += "</tbody>"
                + "          </table>";
        return html;
    }

    public String imprimirTablaServiciosPP() {
        String html;
        html = "<table id=\"tablaServi\" hidden >\n"
                + "        <thead>\n"
                + "                <tr>\n"
                + "                <td></td>\n"
                + "                <td>noOpe</td>\n"
                + "                <td>noSer</td>\n"
                + "                <td>cant</td>\n"
                + "                <td>precEs1</td>\n"
                + "                <td>precEs2</td>\n"
                + "                <td>gpoA2</td>\n"
                + "                <td>clsC</td>\n"
                + "                <td>TxtS</td>\n"
                + "                <td>umdS</td>\n"
                + "                </tr>\n"
                + "        </thead>\n"
                + "        <tbody id=\"cargarServiM\">";
        for (int x = 0; x <= 10; x++) {
            html += "<tr>\n"
                    + "<td><input type=\"checkbox\" name=\"TSpos\" value=" + x + " style=\"width=50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TSnoOpe\" id=\"TSnoOpe" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TSnoS\" id=\"TSnoS" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TScant\" id=\"TScant" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TSpreEs1\" id=\"TSpreEs1" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TSpreEs2\" id=\"TSpreEs2" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TSgpoA2\" id=\"TSgpoA2" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TSclsC\" id=\"TSclsC" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TStxtS\" id=\"TStxtS" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TSumdS\" id=\"TSumdS" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TScont\" id=\"TScont" + x + "\" style=\"width:50px;\"></td>\n"
                    + "</tr>";
        }
        html += "</tbody>"
                + "          </table>";
        return html;
    }

    public String imprimirTablaTextosDescriPP() {
        String html;
        html = "<table id=\"tablaTxtsDes\"  hidden>\n"
                + "        <thead>\n"
                + "                <tr>\n"
                + "                <td></td>\n"
                + "                <td>folSam</td>\n"
                + "                <td>numOpe</td>\n"
                + "                <td>indi</td>\n"
                + "                <td>txtDes</td>\n"
                + "                </tr>\n"
                + "        </thead>\n"
                + "        <tbody id=\"cargarTxtD\">";
        for (int x = 0; x <= 20; x++) {
            html += "<tr>\n"
                    + "<td><input type=\"checkbox\" name=\"TDpos\" value=" + x + " style=\"width=50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TDfolSam\" id=\"TDfolSam" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TDnumOpe\" id=\"TDnumOpe" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TDind\" id=\"TDind" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><textarea name=\"TDtxtD\" id=\"TDtxtD" + x + "\" style=\"width:50px;\"></textarea></td>\n"
                    + "<td><input name=\"TDcont\" id=\"TDcont" + x + "\" style=\"width:50px;\"></td>\n"
                    + "</tr>";
        }
        html += "</tbody>"
                + "          </table>";
        return html;
    }

    public String imprimirTablaMaterialesPP() {
        String html;
        html = "<table id=\"tablaMate\" hidden>\n"
                + "        <thead>\n"
                + "                <tr>\n"
                + "                <td></td>\n"
                + "                <td>noOpe</td>\n"
                + "                <td>ctdO1</td>\n"
                + "                <td>ctdO2</td>\n"
                + "                <td>preO1</td>\n"
                + "                <td>preO2</td>\n"
                + "                <td>gpoA1</td>\n"
                + "                <td>gpoC1</td>\n"
                + "                <td>gpoC2</td>\n"
                + "                <td>contr1</td>\n"
                + "                <td>contr2</td>\n"
                + "                <td>dest</td>\n"
                + "                <td>soli</td>\n"
                + "                <td>plzEnt</td>\n"
                + "                <td>subC</td>\n"
                + "                <td>clvCl</td>\n"
                + "                <td>por</td>\n"
                + "                <td>clC</td>\n"
                + "                <td>acre</td>\n"
                + "                <td>regInt</td>\n"
                + "                <td>ptoD</td>\n"
                + "                <td>noNes</td>\n"
                + "                <td>pedM1</td>\n"
                + "                <td>pedM2</td>\n"
                + "                </tr>\n"
                + "        </thead>\n"
                + "        <tbody id=\"cargarDatOpe2\">";
        for (int y = 0; y <= 15; y++) {
            html += "<tr>\n"
                    + "<td><input type=\"checkbox\" name=\"TMpos\" value=" + y + " style=\"width=50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMnoOpe\" id=\"TMnoOpe" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMctdO1\" id=\"TMctdO1" + y + "\"  style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMctdO2\" id=\"TMctdO2" + y + "\"  style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMpre1\" id=\"TMpre1" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMpre2\" id=\"TMpre2" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMgpoA1\" id=\"TMgpoA1" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMgpoC1\" id=\"TMgpoC1" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMgpoC2\" id=\"TMgpoC2" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMcontr1\" id=\"TMcontr1" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMcontr2\" id=\"TMcontr2" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMdest\" id=\"TMdest" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMsoli\" id=\"TMsoli" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMplzE\" id=\"TMplzE" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMsubC\" id=\"TMsubC" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMclvCl\" id=\"TMclvCl" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMpor\" id=\"TMpor" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMclC\" id=\"TMclC" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMacre\" id=\"TMacre" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMregI\" id=\"TMregI" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMptoD\" id=\"TMptoD" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMnoN\" id=\"TMnoN" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMpedM1\" id=\"TMpedM1" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMpedM2\" id=\"TMpedM2" + y + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TMcont\" id=\"TMcont" + y + "\" style=\"width:50px;\"></td>\n"
                    + "</tr>";
        }
        html += "</tbody>"
                + "          </table>";
        return html;
    }

    public String imprimirTablaCabLotInspPP() {
        String html;
        html = "<table id=\"tablaCabLotIns\" hidden>\n"
                + "        <thead>\n"
                + "                <tr>\n"
                + "                <td>folio</td>\n"
                + "                <td>material</td>\n"
                + "                <td>txtB</td>\n"
                + "                <td>numDoc</td>\n"
                + "                <td>centro</td>\n"
                + "                <td>user</td>\n"
                + "                </tr>\n"
                + "        </thead>\n"
                + "        <tbody id=\"cargarCabLotIns\">";
        for (int x = 0; x <= 10; x++) {
            html += "<tr>\n"
                    + "<td><input type=\"text\" name=\"TLIfol\" id=\"TLIfol" + x + "\" style=\"width:100px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLImat\" id=\"TLImat" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLItxtB\" id=\"TLItxtB" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLInumD\" id=\"TLInumD" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIcent\" id=\"TLIcent" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIuser\" id=\"TLIuser" + x + "\" style=\"width:50px;\"></td>\n"
                    + "</tr>";
        }
        html += "</tbody>"
                + "          </table>";
        return html;
    }

    public String imprimirTablaPosLotInspPP() {
        String html;
        html = "<table id=\"tablaPosLotIns\" hidden >\n"
                + "        <thead>\n"
                + "                <tr>\n"
                + "                <td>folio</td>\n"
                + "                <td>numCaract</td>\n"
                + "                <td>txtBCarInsp</td>\n"
                + "                <td>desBConj</td>\n"
                + "                <td>entCat</td>\n"
                + "                <td>tamMues</td>\n"
                + "                <td>numUn</td>\n"
                + "                <td>valOrg</td>\n"
                + "                <td>codigo</td>\n"
                + "                <td>undMe</td>\n"
                + "                <td>txtB</td>\n"
                + "                <td>catal</td>\n"
                + "                <td>user</td>\n"
                + "                </tr>\n"
                + "        </thead>\n"
                + "        <tbody id=\"cargarCabLotIns\">";
        for (int x = 0; x <= 10; x++) {
            html += "<tr>\n"
                    + "<td><input type=\"text\" name=\"TLIPfol\" id=\"TLIPfol" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPnumCaract\" id=\"TLIPnumCaract" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPtxtBCarInsp\" id=\"TLIPtxtBCarInsp" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPdesBConj\" id=\"TLIPdesBConj" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPentCat\" id=\"TLIPentCat" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPtamMues\" id=\"TLIPtamMues" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPnumUn\" id=\"TLIPnumUn" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPvalOrg\" id=\"TLIPvalOrg" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPcod\" id=\"TLIPcod" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPundMe\" id=\"TLIPundMe" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPtxtB\" id=\"TLIPtxtB" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPcatal\" id=\"TLIPcatal" + x + "\" style=\"width:50px;\"></td>\n"
                    + "<td><input type=\"text\" name=\"TLIPuser\" id=\"TLIPuser" + x + "\" style=\"width:50px;\"></td>\n"
                    + "</tr>";
        }
        html += "</tbody>"
                + "          </table>";
        return html;
    }
}
