package com.example.Patron_Builder_Mascota;

public interface IMascotaBuilder {
    IMascotaBuilder setDatosBasicos(String nombre, String especie, String raza);

    IMascotaBuilder setEdadYTamano(int edad, TamanoMascota tamano);

    IMascotaBuilder addNecesidadEspecial(String necesidad);

    IMascotaBuilder setPreferenciasTrato(String preferencia);

    Mascota build();
}
