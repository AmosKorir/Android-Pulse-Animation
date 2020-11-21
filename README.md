# Covista

Image Search App- MVVM clean Architecture

# Modules
The application is divided into the following modules (Clean Architecture)

## 1 app

Contains app UI implementation, Activities,fragments and adapters

## 2 Viewmodels

This modules has all the viewmodels tha communicate with the repositories in the datasource module.

## 3 data

This module is a data source, it provide data from api call and local database. It is consumed by the viewmodels

## 4 domain

This a java module that has the app use cases and the utility classes that are used in all the modules

### Using the following Libraries

        1.Koin dependency injection

        2.Rxjava for Streams

        3.Retrofit and Okhttp

        5.Room

<table>
<tr>
<td>
<img  width="200" height="400" src="https://github.com/AmosKorir/covista/blob/master/art/a.png"/>
</td>
<td>

<img  width="200" height="400" src="https://github.com/AmosKorir/covista/blob/master/art/b.png"/>
</td>
</tr>
</table>

