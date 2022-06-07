/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.utiles;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 *
 * @author sebastian
 */
public class Utilidades {

    public static Field getField(String name, Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Field aux = null;
        for (int i = 0; i < fields.length; i++) {

            if (name.toString().equalsIgnoreCase(fields[i].getName())) {
                aux = fields[i];
                break;
            }

        }
        if (aux != null) return aux;
        
        fields = clazz.getSuperclass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {

            if (name.toString().equalsIgnoreCase(fields[i].getName())) {
                aux = fields[i];
                break;
            }

        }

        return aux;
    }

    public static Method getMethod(String name, Class clazz) {

        Method[] methods = clazz.getDeclaredMethods();
        Method aux = null;

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
            if (name.toString().equalsIgnoreCase(methods[i].getName())) {
                aux = methods[i];
                break;
            }

        }
        if(aux != null) return aux;
        methods = clazz.getSuperclass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
            if (name.toString().equalsIgnoreCase(methods[i].getName())) {
                aux = methods[i];
                break;
            }

        }
        return aux;
    }

    public static Object cambiarDatos(Object dato, String field, Object a) throws Exception {

        Field fieldA = getField(field, a.getClass());
        char[] arr = field.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);
        Method method = getMethod("set" + new String(arr), a.getClass());
        try {         
            if (fieldA.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
                method.invoke(a, transformarDatoNumber(fieldA.getType(), dato.toString()));
            } else if(fieldA.getType().isEnum()) {
                //Class fieldA = revisa que sea de tipo Enum
                //dato.toString() = revisa si coincide el dato que se envia con los existentes
               Enum enume = Enum.valueOf((Class)fieldA.getType(),dato.toString());
               method.invoke(a, enume);
            } else if(fieldA.getType().getSimpleName().equalsIgnoreCase("Boolean")) {
                System.out.println("Boolean");
                method.invoke(a,  dato.toString().equalsIgnoreCase("true"));
            }
            else {
                //Solo para Strings
                method.invoke(a, dato);
            }

        } catch (Exception e) {
            System.out.println(e + "  " + field);
        }
        return a;
        //System.out.println("set"+new String(arr));
    }

    public static Number transformarDatoNumber(Class type, String dato) {
        Number number = null;
        if (type.getSimpleName().equalsIgnoreCase(Integer.class.getSimpleName())) {
            number = Integer.parseInt(dato);
        }
        if (type.getSimpleName().equalsIgnoreCase(Double.class.getSimpleName())) {
            number = Double.parseDouble(dato);
        }
        if (type.getSimpleName().equalsIgnoreCase(Float.class.getSimpleName())) {
            number = Float.parseFloat(dato);
        }
        if (type.getSimpleName().equalsIgnoreCase(Short.class.getSimpleName())) {
            number = Short.parseShort(dato);
        }
        return number;
    }

}
