# Proyecto Bies

## Descripción

En una galaxia muy lejana existe el planeta Bies, hogar de una variedad de seres vivos con características únicas. Este proyecto en Java modela los insectos y otros entes vivos del planeta Bies, siguiendo una historia que pone énfasis en el desacople entre los distintos entes y sus comportamientos.

## Requisitos

- Java JDK 17 o superior
- Uso de `record` donde convenga para representar datos inmutables y mejorar la claridad del código.

## Historia

En Bies, hay tres tipos principales de insectos:

- **Mosca**: Tiene 2 alas y 6 patas. Come carroña.
- **Mariposa**: Tiene 2 alas y no tiene patas. Come miel.
- **Araña**: No tiene alas y tiene 8 patas. Come hongos.

### Comportamientos de los Insectos

1. **Vuelo y Caminata**:
   - Para volar, un insecto necesita al menos dos alas.
   - Para caminar, un insecto necesita al menos dos patas.
   - La probabilidad de perder un ala al volar es `1/alás`, y de perder una pata al caminar es `1/patas`. Esto se debe a un fenómeno llamado degradación motora.

2. **Carroña**:
   - La carroña es un estado de un insecto que ha perdido su capacidad de volar y/o caminar.
   - La carroña es consumida por otros insectos según su dieta.

3. **Innombrables**:
   - Entes no vivos que pueden volar o caminar, pero no son insectos.
   - Todos los seres vivos en Bies se alimentan.

## Estructura del Modelo Orientado a Objetos

### Clases Principales

- **InsectoAbstracto**: Clase base para todos los insectos, define comportamientos generales como volar y caminar.
- **Mosca**: Hereda de `InsectoAbstracto`, implementa comportamiento específico para las moscas.
- **Mariposa**: Hereda de `InsectoAbstracto`, implementa comportamiento específico para las mariposas.
- **Arana**: Hereda de `InsectoAbstracto`, implementa comportamiento específico para las arañas.
- **Carronia**: Representa un insecto en estado de carroña.
- **InnombrableAbstracto**: Representa entes no vivos que pueden volar o caminar.
- **Bies**: Clase principal que gestiona la lista de seres vivos y coordina la degradación y consumo de carroñas.

### Métodos Clave

- **degradarInsecto**: Aplica la degradación motora a los insectos.
- **mostrarCarronias**: Muestra la lista de carroñas.
- **consumirCarronias**: Permite a los insectos consumir carroñas si es posible.

## Maven
El proyecto está configurado con Maven. 

Para compilar el proyecto, ejecutar el siguiente comando en la raíz del proyecto:

```bash
mvn compile
```

Para ejecutar el proyecto, ejecutar el siguiente comando en la raíz del proyecto:

```bash
mvn exec:java
```

Para compilar y ejecutar el proyecto, ejecutar el siguiente comando en la raíz del proyecto:

```bash
mvn compile exec:java
```

Para realizar los tests del proyecto, ejecutar el siguiente comando en la raíz del proyecto:

```bash
mvn test
```

Para limpiar el proyecto, ejecutar el siguiente comando en la raíz del proyecto:

```bash
mvn clean
```

Para empaquetar el proyecto, ejecutar el siguiente comando en la raíz del proyecto:

```bash
mvn package
```

Ademas de todo esto el proyecto esta configurado para realizar un deploy en GitHub, para esto es necesario tener un token de acceso a GitHub y configurarlo en el archivo `settings.xml` que se encuentra en la carpeta `.m2` de su usuario. El token debe tener permisos para realizar un deploy en GitHub.

Más información sobre cómo generar un token de acceso a GitHub en el siguiente enlace: 
- [Creating a personal access token](https://docs.github.com/en/organizations/managing-programmatic-access-to-your-organization/setting-a-personal-access-token-policy-for-your-organization#restricting-access-by-personal-access-tokens-classic)

El archivo `settings.xml` debe tener la siguiente estructura:

```xml
<settings>
    <servers>
        <server>
            <id>github</id>
            <username>tu-usuario</username>
            <password>tu-token-clásico</password>
        </server>
    </servers>
    <profiles>
        <profile>
            <id>github</id>
            <properties>
                <github.username>tu-usuario</github.username>
                <github.token>tu-token-clásico</github.token>
            </properties>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>github</activeProfile>
    </activeProfiles>
</settings>
```