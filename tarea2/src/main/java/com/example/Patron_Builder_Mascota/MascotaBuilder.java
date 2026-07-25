package com.example.Patron_Builder_Mascota;

public class MascotaBuilder implements IMascotaBuilder{
    private Mascota mascota;

    public MascotaBuilder() {
        mascota = new Mascota();
    }

    @Override
    public IMascotaBuilder setDatosBasicos(String nombre, String especie, String raza) {

        mascota.setNombre(nombre);
        mascota.setEspecie(especie);
        mascota.setRaza(raza);

        return this;
    }

    @Override
    public IMascotaBuilder setEdadYTamano(int edad, TamanoMascota tamano) {

        mascota.setEdad(edad);
        mascota.setTamano(tamano);

        return this;
    }

    @Override
    public IMascotaBuilder addNecesidadEspecial(String necesidad) {

        mascota.agregarNecesidadEspecial(necesidad);

        return this;
    }

    @Override
    public IMascotaBuilder setPreferenciasTrato(String preferencia) {

        mascota.agregarPreferenciaTrato(preferencia);

        return this;
    }

    @Override
    public Mascota build() {
        return mascota;
    }
}
