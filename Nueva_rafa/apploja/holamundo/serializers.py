from holamundo.models import Carrera,Paralelo
from rest_framework import serializers

class CarreraSerializer(serializers.ModelSerializer):
    class Meta:
        model=Carrera
        fields=('nombreCarrera','nombreCiclos','nombreCiclos','codigoCarrera','numeroDocentes')
class ParaleloSerializer(serializers.ModelSerializer):
    class Meta:
        model=Paralelo
        fields=('carrera','ciclo','nombre','numeroEstudiantes')