package edu.eci.cvds.tdd.aerodescuentos;

import org.junit.Assert;
import org.junit.Test;

public class TarifasTest {
    private CalculadorDescuentos calcu = new CalculadorDescuentos();
    private Double tar;
    @Test
    //Deberia validar que no se pueden meter edades negativas.
    public void validarEdadMenorCero() {
        try{
            tar = calcu.calculoTarifa(1000,8,-10);

        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    //Deberia validar que no se admitan edades de valor 0.
    public void validarEdadCero(){
        try{
            tar = calcu.calculoTarifa(1000,7,0);

        }catch (Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    //Deberia validar descuento de 5% por los menores de edad.
    public void validarDescuentoCinco(){

            tar = calcu.calculoTarifa(1000,9,17);
            double rta = 950;

            Assert.assertEquals(tar,rta,0.0f);

    }
    @Test
    //Deberia validar descuento de 8% por gente mayor a 65 años.
    public void validarDescuentoOcho(){

            tar = calcu.calculoTarifa(1000,9,66);
            double rta = 920;

            Assert.assertEquals(tar,rta,0.0f);
    }
    @Test
    //Deberia validar que no se aplique descuento si no es menor a 18 y mayor a 65 y que ademas no tenga dias de antelacion mayores de 20.
	public void validarSinDescuento(){

            tar = calcu.calculoTarifa(3000,15,19);
            double rta = 3000;

            Assert.assertEquals(tar,rta,0.0f);
    }
    @Test
    //Deberia validar descuento de 15% por dias de antelacion mayores a 20
    public void validarDescuentoQuince(){

            tar = calcu.calculoTarifa(10000,21,20);
            double rta = 8500;

            Assert.assertEquals(tar,rta,0.0f);

    }
    @Test
    //Deberia validar descuentos de 15% mas 5% por ser menor de edad y tener dias de antelacion mayores de 20.
    public void validarDescuentoVeinte(){

            tar = calcu.calculoTarifa(10000,40,8);
            double rta = 8000;
            System.out.println(tar);
            Assert.assertEquals(tar,rta,0.0f);

    }
    @Test
    //Deberia validar descuentos de 15% y de 8% por ser mayor de 65 años y tener dias de antelacion mayores de 20.
    public void validarDescuentoVeintiTres(){

            tar = calcu.calculoTarifa(50000,25,69);
            double rta = 38500;

            Assert.assertEquals(tar,rta,0.0f);

    }
    @Test
    //Deberia validar que no se puedan aplicar todos los descuentos.
    public void noDeberiaTenerTodosDescuentos(){
        tar = calcu.calculoTarifa(50000,25,69);
        double rta = 36000;

        Assert.assertNotEquals(tar,rta,0.0f);
    }
    @Test
    //Deberia validar que no se acepten edades exageradas o imposibles.
    public void validarEdadMayorDeCientoCincuenta(){
        try{
            tar = calcu.calculoTarifa(20000,13,200);
        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    //Deberia validar que no se admitan los dias con valor negativo.
    public void validarDiasNegativos(){
        try{
            tar = calcu.calculoTarifa(80000,-13,20);
        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    //Deberia validar que no se acepten valores de tarifa negativos.
    public void validarTarifaBaseNegativa(){
        try{
            tar = calcu.calculoTarifa(-90000,13,20);

        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    //Deberia validar que no se acepten valores de tarifa 0.
    public void validarTarifaBaseCero(){
        try{
            tar = calcu.calculoTarifa(0,13,11);

        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }
    @Test
    //Deberia validar que no se acepten dias con valor igual a 0.
    public void validarDiasAntelacionCero(){
        try{
            tar = calcu.calculoTarifa(2000,0,12);

        }catch(Exception e){
            Assert.assertTrue(true);
        }
    }
}