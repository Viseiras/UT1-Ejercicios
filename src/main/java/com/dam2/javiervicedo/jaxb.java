package com.dam2.javiervicedo;

import jakarta.xml.bind.*;

import java.io.File;

public class jaxb {
    public static void main(String[] args)
    {
        ColeccionJuegos coleccion = new ColeccionJuegos();
        juego j1 = new juego("Minecraft",2010,"Mojang");
        juego j2 = new juego("WoW",2006,"Blizzard");
        coleccion.addjuego(j1);
        coleccion.addjuego(j2);

        try{
            JAXBContext contexto = JAXBContext.newInstance(coleccion.getClass());
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(coleccion,new File("Vise.xml"));

            JAXBContext context2= JAXBContext.newInstance(ColeccionJuegos.class);
            Unmarshaller unmarshaller = context2.createUnmarshaller();
            ColeccionJuegos coleccion2 = (ColeccionJuegos) unmarshaller.unmarshal(new File("Vise.xml"));
            coleccion2.muestrajuego();
        }
        catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
