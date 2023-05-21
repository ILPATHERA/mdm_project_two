# ProjectB - Action Recognition-Modell mit DJL

Dieses Projekt stellt ein Action Recognition-Modell bereit, das mithilfe der Deep Java Library (DJL) implementiert wurde. Das Modell ist in der Lage, Aktionen in Bildern zu erkennen und vorherzusagen.

## Voraussetzungen
Bevor Sie dieses Modell verwenden, stellen Sie sicher, dass die folgenden Voraussetzungen erfüllt sind:

- Docker installiert und konfiguriert
- Ein kompatibles Betriebssystem (Linux, macOS oder Windows)
- Zugriff auf ein Terminal oder eine Befehlszeile

## Installation und Setup

1. Klonen Sie das Repository von GitHub:

git clone <https://github.com/ILPATHERA/mdm_project_two>

2. Wechseln Sie in das Projektverzeichnis:

cd mdm_project_two

3. Bauen Sie den Docker-Container:

docker build -t action-recognition .

4. Starten Sie den Docker-Container:

docker run -p 8080:8080 action-recognition

Der Container wird gestartet und die Anwendung wird auf Port 8080 bereitgestellt.

## Verwendung
1. Öffnen Sie einen Webbrowser und navigieren Sie zu http://localhost:8080.
2. Wählen Sie ein Bild im JPEG-Format aus, indem Sie auf den Button "Choose Picture" klicken.
3. Klicken Sie auf "Predict", um die Vorhersage des Action Recognition-Modells zu erhalten.

## Anpassung
Sie können das Modell und die Anwendung an Ihre spezifischen Anforderungen anpassen. Hier sind einige mögliche Anpassungen:

- Austausch des Action Recognition-Modells: Ersetzen Sie das aktuelle Modell durch ein eigenes Modell oder verwenden Sie ein vortrainiertes Modell aus DJL.
- Verbesserung der Benutzeroberfläche: Passen Sie das UI an, um zusätzliche Funktionen oder ein verbessertes Benutzererlebnis bereitzustellen.
- Skalierung und Bereitstellung: Passen Sie die Docker-Konfiguration an, um die Anwendung in einer skalierbaren Umgebung zu betreiben, z. B. mit Kubernetes oder einem anderen Containerorchestrierungssystem.

https://djl.ai/examples/docs/action_recognition.html