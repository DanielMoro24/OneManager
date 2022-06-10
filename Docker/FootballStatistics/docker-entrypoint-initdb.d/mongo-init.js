db.getSiblingDB('admin').createUser(
  {
    user: 'microUser',
    pwd: 'football',
    roles: [{ role: 'readWrite', db: 'footballStatistics' }],
  },
);

db.getSiblingDB('footballStatistics').createCollection('playerStatistics');