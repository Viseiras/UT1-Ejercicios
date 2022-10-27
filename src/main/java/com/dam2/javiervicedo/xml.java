package com.dam2.javiervicedo;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class xml {
    public void escribeXML()
    {
        try{
            ArrayList<juego> juegos= new ArrayList<>();
            juegos.add(new juego("Minecraft",2010,"Mojang"));
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db= dbf.newDocumentBuilder();
            DOMImplementation domi = db.getDOMImplementation();
            Document docu = domi.createDocument(null,"xml",null);
            Element raiz = docu.createElement("lenguajes");
            docu.getDocumentElement().appendChild(raiz);
            Element nodoDatos,nodoJuegos;
            Text texto;
            for(juego j: juegos)
            {
                nodoJuegos=docu.createElement("juego");
                raiz.appendChild(nodoJuegos);
                nodoDatos= docu.createElement("nombre");
                nodoJuegos.appendChild(nodoDatos);
                texto=docu.createTextNode(j.getNombre());
                nodoDatos.appendChild(texto);
                nodoDatos= docu.createElement("estudio");
                nodoJuegos.appendChild(nodoDatos);
                texto=docu.createTextNode(j.getEstudio());
                nodoDatos.appendChild(texto);
                nodoDatos= docu.createElement("anyo");
                nodoJuegos.appendChild(nodoDatos);
                texto=docu.createTextNode(String.valueOf(j.getAnyo()));
                nodoDatos.appendChild(texto);
            }
            Source source = new DOMSource(docu);
            Result resultado = new StreamResult(new File("generoJuegos.xml"));
            Transformer transform = TransformerFactory.newInstance().newTransformer();
            transform.setOutputProperty("indent","yes");
            transform.transform(source,resultado);
        }
        catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)
    {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db= dbf.newDocumentBuilder();
            Document document = db.parse("generoJuegos.xml");
            NodeList nodos = document.getElementsByTagName("juego");
            Node nodito;
            Element elemento;
            for (int i=0;i<nodos.getLength();i++)
            {
                nodito=nodos.item(i);
                elemento=(Element) nodito;
                System.out.println(elemento.getElementsByTagName("nombre").item(0).getTextContent());
                System.out.println(elemento.getElementsByTagName("estudio").item(0).getTextContent());
                System.out.println(elemento.getElementsByTagName("anyo").item(0).getTextContent());
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }


}
