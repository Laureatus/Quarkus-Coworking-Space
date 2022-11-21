# UeK-223_22-3216_LFa

# Aufgabe
Die zu entwickelnde Prototyp soll aus einer Server- und Client-Applikation bestehen. Die Client-Applikation benutzt
die Server-Applikation über eine HTTP API. Für den Prototyp sind folgende, menschliche Akteure vorgesehen:
› Administrator
› Mitglied
› Besucher (nicht authentifizierter Benutzer)
Folgende funktionalen Anwendungsfälle sollen mindestens im Prototypen implementiert werden:
› Als Besucher möchte ich mich mit meinem Vor- und Nachnamen, meiner E-Mail-Adresse und einem Passwort
registrieren, damit ich die Rolle Mitglied bekommen kann.
› Als Besucher möchte ich mich mit meiner E-Mail-Adresse und meinem Passwort anmelden, damit ich mich als
Mitglied oder Administrator authentifizieren kann.
› Als Mitglied möchte ich halbe und ganze Tage an bestimmten Daten im Coworking Space als Buchung anfragen,
damit ich die Angebote des Coworking Space nutzen kann.
› Als Mitglied möchte ich den Status meiner Buchungen überprüfen, damit ich erfahre, ob meine Buchung
bestätigt oder abgelehnt wurde.
› Als Mitglied kann ich meine zukünftigen Buchungen stornieren, damit ich auf Veränderungen in meiner
Terminplanung reagieren kann.
› Als Administrator kann ich Mitglieder verwalten (erstellen, bearbeiten, löschen), damit ich die Mitglieder
organisieren kann.
› Als Administrator kann ich Buchungsanfragen akzeptieren und ablehnen, damit die Mitglieder das Angebot des
Coworking Space nutzen können.
› Als Administrator kann ich Buchungen verwalten (erstellen, bearbeiten, löschen), damit ich die Buchungen
organisieren kann.
Folgende nicht-funktionale Anforderungen sollen mindestens im Prototypen umgesetzt werden:
› Das Datenmodell erfüllt die erste, zweite und dritte Normalform nach der relationalen Entwurfstheorie.
› Der erste Besucher bekommt nach der Registrierung die Rolle Administrator anstatt Mitglied.
› Die Authentifizierung erfolgt mittels JSON Web Token (JWT nach RFC 7519) über den HTTP Header
'Authorization'.
› Das JWT läuft 24 Stunden nach der Ausstellung ab und verliert seine Gültigkeit.
› Das JWT wird clientseitig während dessen Lebensdauer persistent aufbewahrt.
