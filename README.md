README - Búsqueda de Números Primos con Hilos en Java

📝 Descripción del Proyecto
Este proyecto implementa dos enfoques para encontrar números primos hasta un valor N:

Versión secuencial: Búsqueda tradicional usando un solo hilo de ejecución

Versión paralela: Búsqueda utilizando múltiples hilos para mejorar el rendimiento

El código sigue la estructura del laboratorio de Programación Paralela mostrado en el PDF de referencia, adaptado para resolver el problema de búsqueda de números primos.

🛠️ Requisitos
Java JDK 17 o superior

IDE NetBeans (recomendado) o cualquier IDE Java

Sistema operativo: Windows, Linux o macOS

🏗️ Estructura del Proyecto:

HilosEjecucion/
├── src/
│   ├── HilosEjecucion/
│   │   ├── Main.java            # Clase principal con método main
│   │   ├── PrimeSecuencial.java # Implementación secuencial
│   │   └── PrimeParalelo.java   # Implementación con hilos
├── README.md                    # Este archivo
└── nbproject/                   # Configuración de NetBeans (si se usa)

🚀 Cómo Ejecutar el Proyecto
Clonar el repositorio o descargar los archivos

Abrir el proyecto en NetBeans o tu IDE favorito

Compilar y ejecutar la clase Main

Ejecución desde línea de comandos:
bash
Copy
javac -d bin src/HilosEjecucion/*.java
java -cp bin HilosEjecucion.Main
📊 Entrada del Programa
Al ejecutar el programa, se solicitará:

El valor máximo N para buscar números primos

El número de tareas/hilos a usar para la versión paralela

Los números primos encontrados secuencialmente y el tiempo tomado

Los números primos encontrados en paralelo

Mensajes de seguimiento de cada hilo durante la ejecución paralela
