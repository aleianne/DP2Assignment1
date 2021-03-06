//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.3.1-b171012.0423 
// Vedere <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2018.08.21 alle 04:23:46 PM CEST 
//


package it.polito.dp2.NFV.sol1.jaxb;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per linkType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="linkType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="link-name" type="{http://www.example.com/nfv}nfvName"/&gt;
 *         &lt;element name="destinationNode" type="{http://www.example.com/nfv}nfvName"/&gt;
 *         &lt;element name="sourceNode" type="{http://www.example.com/nfv}nfvName"/&gt;
 *         &lt;element name="latency" type="{http://www.example.com/nfv}positiveInt" minOccurs="0"/&gt;
 *         &lt;element name="throughput" type="{http://www.example.com/nfv}throughputType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "linkType", propOrder = {
    "linkName",
    "destinationNode",
    "sourceNode",
    "latency",
    "throughput"
})
public class LinkType {

    @XmlElement(name = "link-name", required = true)
    protected String linkName;
    @XmlElement(required = true)
    protected String destinationNode;
    @XmlElement(required = true)
    protected String sourceNode;
    protected BigInteger latency;
    protected Float throughput;

    /**
     * Recupera il valore della proprietà linkName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * Imposta il valore della proprietà linkName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLinkName(String value) {
        this.linkName = value;
    }

    /**
     * Recupera il valore della proprietà destinationNode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationNode() {
        return destinationNode;
    }

    /**
     * Imposta il valore della proprietà destinationNode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationNode(String value) {
        this.destinationNode = value;
    }

    /**
     * Recupera il valore della proprietà sourceNode.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceNode() {
        return sourceNode;
    }

    /**
     * Imposta il valore della proprietà sourceNode.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceNode(String value) {
        this.sourceNode = value;
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
