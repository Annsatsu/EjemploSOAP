use('Vehiculos')
db.Vehiculos.insertOne({_id:1,'placa':'AKW823','marca':'Renault','modelo':2019,'precio':80000000})
db.Vehiculos.insertOne({_id:2,'placa':'VYD741','marca':'Renault','modelo':2009,'precio':20000000})
db.Vehiculos.insertOne({_id:3,'placa':'KRE460','marca':'KIA','modelo':2020,'precio':100000000})
db.Vehiculos.find()