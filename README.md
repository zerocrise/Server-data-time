# Server-data-time
Realizzare un’applicazione Client–Server UDP in Java che consenta a più client di inviare messaggi a un server, il quale risponderà secondo le specifiche richieste.

Traccia

Devi realizzare un server UDP che riceva messaggi di testo da uno o più client e risponda al mittente.

Funzionamento del server UDP

Il server deve:

Mettersi in ascolto sulla porta 5000

Ricevere messaggi testuali dai client

Stampare su console:

Indirizzo IP del client

Porta del client

Messaggio ricevuto

Rispondere al client secondo le seguenti regole:

Se il messaggio è "DATA" → risponde con la data e ora correnti

Se il messaggio è "STOP" → risponde "Server in chiusura" e termina l’esecuzione

Per qualsiasi altro messaggio → risponde "Messaggio ricevuto: <testo>"
