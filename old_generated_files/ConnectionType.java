//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.01.16 alle 06:15:27 PM CET 
//


package it.polito.dp2.NFV.sol1.jaxb;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per connectionType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="connectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="hostname1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="hostname2" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="latency" type="{}positiveInt" />
 *       &lt;attribute name="throughput" type="{}throughput-type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connectionType")
public class ConnectionType {

    @XmlAttribute(name = "hostname1")
    protected String hostname1;
    @XmlAttribute(name = "hostname2")
    protected String hostname2;
    @XmlAttribute(name = "latency")
    protected BigInteger latency;
    @XmlAttribute(name = "throughput")
    protected Float throughput;

    /**
     * Recupera il valore della proprietà hostname1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostname1() {
        return hostname1;
    }

    /**
     * Imposta il valore della proprietà hostname1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostname1(String value) {
        this.hostname1 = value;
    }

    /**
     * Recupera il valore della proprietà hostname2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostname2() {
        return hostname2;
    }

    /**
     * Imposta il valore della proprietà hostname2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostname2(String value) {
        this.hostname2 = value;
    }

    /**
     * Recupera il valore della proprietà latency.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLatency() {
        return latency;
    }

    /**
     * Imposta il valore della proprietà latency.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLatency(BigInteger value) {
        this.latency = value;
    }

    /**
     * Recupera il valore della proprietà throughput.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getThroughput() {
        return throughput;
    }

    /**
     * Imposta il valore della proprietà throughput.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setThroughput(Float value) {
        this.throughput = value;
    }

}
