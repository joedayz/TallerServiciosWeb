package pe.joedayz.libreria.modelos;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlEnum
@XmlType(name = "formato")
public enum FormatoArchivo {

	@XmlEnumValue("pdf")
	PDF,

	@XmlEnumValue("mobi")
	MOBI,

	@XmlEnumValue("epub")
	EPUB;

}
