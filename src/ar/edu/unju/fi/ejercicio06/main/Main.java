package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte)45,12f); 
		Converter<FelinoDomestico,FelinoSalvaje> converter = x-> new FelinoSalvaje(x.getNombre(),x.getEdad(),x.getPeso());
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjetos(felino1);
		
		FelinoSalvaje felino= new FelinoSalvaje("Tanner", (byte)20,186f);
		boolean aux=Converter.isNotNull(felino);
		if(aux=true){
			Converter<FelinoSalvaje,FelinoDomestico> converter2 = a-> new FelinoDomestico(a.getNombre(),a.getEdad(),a.getPeso());
			FelinoDomestico felino2 = converter2.convert(felino);
			converter2.mostrarObjetos(felino2);
		}
		else {
			System.out.println("No hay objeto a convertir");
		}
	}

}