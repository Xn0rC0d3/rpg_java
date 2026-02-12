package com.emiliojimeno.daw.rpg;

public class Lore {

    public static void printEsqueleto(){
        System.out.println("""
                \n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                Llegas a las ruinas tras atravesar un bosque que parece contener la respiración.
                Asterhûn fue, según las leyendas, un santuario construido por una civilización desaparecida, 
                pero ahora solo quedan columnas derruidas y un silencio que pesa como una advertencia.
                Al cruzar el arco principal, una corriente de aire frío recorre el pasillo de piedra. 
                El eco de pasos ajenos resuena entre las paredes. No tardas en descubrir su origen: 
                un esqueleto imponente armado con hacha y escudo, custodiando la entrada como si aún 
                sirviera a un rey muerto hace siglos. 
                Su calavera se gira con un crujido seco, como si reconociera al intruso,
                abalanzándose violentamente sobre ti.
                
                --- Pulsa <intro> para continuar...
                """);
    }

    public static void printSireno(){
        System.out.println("""
                \n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                Tras derrotarlo, el pasillo se abre hacia una sala circular donde inscripciones antiguas
                brillan tenuemente al tacto de tu piel, como si la ruina misma despertara.
                Un corredor descendente lleva a una zona donde el aire se vuelve húmedo y
                el sonido del agua reverbera. 
                Llegas a una cámara inundada, con plataformas de piedra que emergen del agua oscura.
                En el centro, una figura se desliza bajo la superficie: 
                un sireno armado con un tridente, mitad guardián, mitad depredador. 
                Sus ojos brillan con inteligencia antigua, y su voz emite un canto grave 
                que hace vibrar las paredes.
                
                Cuando avanzas, el sireno emerge, salpicando agua helada, como si defendiera un secreto 
                sumergido desde tiempos remotos y, con una rapidez indescriptible, carga contra ti.
                
                --- Pulsa <intro> para continuar...
                """);
    }

    public static void printDragon(){
        System.out.println("""
                \n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                Tras vencerlo, el agua comienza a retirarse lentamente, 
                revelando un pasadizo oculto bajo el nivel de la cámara.
                
                El nuevo pasadizo conduce a una grieta natural que se abre en una enorme caverna 
                iluminada por ríos de lava. El calor es casi insoportable. En el centro, sobre un 
                promontorio de roca negra, duerme un dragón cuyos escamas reflejan el fuego como 
                espejos rojos y dorados.
                
                El simple crujido de una piedra bajo tus botas basta para que el dragón 
                abra un ojo, luego el otro, y despliegue sus alas con un estruendo que hace temblar la caverna.
                Es un guardián ancestral, quizá el último de su linaje, y su presencia basta para 
                hacer que la ruina parezca viva.
                
                --- Pulsa <intro> para continuar...
                """);
    }

    public static void printParca(){
        System.out.println("""
                \n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                Tras la victoria, el dragón cae, y un puente de roca se desploma 
                revelando una salida hacia un nivel más profundo.
                
                La siguiente zona es completamente distinta: un corredor estrecho donde la luz parece 
                apagarse a cada paso. Las antorchas se consumen más rápido de lo normal, y el aire 
                se vuelve pesado, casi irreal.
                En el extremo del pasillo, una figura encapuchada flota a unos centímetros del suelo. 
                Una parca, esbelta y silenciosa, sostiene una guadaña cuya hoja parece absorber la luz.
                
                No habla, no respira, no se mueve hasta que el protagonista está lo bastante cerca. 
                Entonces, la guadaña se eleva con un movimiento lento, casi ritual, como si marcara el 
                inicio de un duelo inevitable.
                
                --- Pulsa <intro> para continuar...
                """);
    }

    public static void printArpia(){
        System.out.println("""
                \n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                Tras derrotarla, la oscuridad retrocede y una puerta de piedra se abre sola, 
                como si la ruina reconociera tu avance.
                
                El último tramo conduce a una sala abierta al cielo, aunque el resto de la 
                estructura está enterrada. El viento sopla con fuerza, levantando polvo y hojas secas.
                En lo alto de un pedestal, una arpía te observa con ojos afilados. 
                Sus alas se extienden con elegancia salvaje, y sus patas de águila se aferran a la 
                piedra como si fuera su trono.
                
                La criatura lanza un grito que resuena en toda la sala, un desafío final para quien 
                ha llegado tan lejos. Su figura se recorta contra el cielo, como si fuera la 
                guardiana del último secreto de Asterhûn.
                
                --- Pulsa <intro> para continuar...
                """);
    }

    public static void contarHistoria(int indice){
        switch(indice){
            case 0:
                printEsqueleto();
                break;
            case 1:
                printSireno();
                break;
            case 2:
                printDragon();
                break;
            case 3:
                printParca();
                break;
            case 4:
                printArpia();
                break;
        }
    }
    public static void printPrologo(){
        System.out.println("\n\n**************************************************************************************************\n");
        Arte.printTituloVertical();
        System.out.println("""
                **************************************************************************************************
                
                Dicen los ancianos que Asterhûn fue un santuario erigido antes de que los reinos tuvieran nombre. 
                Un lugar donde los sabios hablaban con los espíritus del mundo y donde la magia fluía 
                como un río sereno. Pero algo ocurrió. Algo tan terrible que las puertas del santuario se 
                cerraron de golpe y la tierra misma decidió olvidarlo.
                
                Durante siglos, las ruinas permanecieron ocultas bajo la maleza y el silencio. Hasta ahora.
                
                En los últimos meses, rumores inquietantes comenzaron a extenderse por las aldeas cercanas. 
                Luces extrañas brillaban entre los árboles al caer la noche. 
                Animales desaparecían sin dejar rastro. 
                Y algunos viajeros aseguraban haber escuchado voces antiguas llamando desde lo profundo 
                del bosque, como si Asterhûn despertara tras un sueño demasiado largo.
                
                El protagonista, movido por la curiosidad, el deber o quizá un destino que aún no comprende, 
                decide adentrarse en el corazón del bosque. Allí, entre raíces retorcidas y piedras 
                cubiertas de musgo, encuentra el umbral quebrado del santuario perdido.
                
                Una brisa helada atraviesa la entrada, como un susurro de bienvenida… o de advertencia.
                
                Las ruinas aguardan.
                Algo en su interior ha vuelto a la vida.
                Y solo quien se atreva a cruzar ese umbral descubrirá la verdad que Asterhûn ha 
                guardado durante siglos.
                """);
    }
}
