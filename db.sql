
DROP TABLE IF EXISTS lampione;
DROP TABLE IF EXISTS sensore;
DROP TABLE IF EXISTS misuratore;
DROP TABLE IF EXISTS area;

------ RUNNARE MICROSERVIZIO PERCHE' SI CREI LE TABELLE -------

INSERT INTO area(nome,autoMode,lvlInf,lvlSup) VALUES
                                                  ('Area Fusine', false, 0, 100),
                                                  ('Area Costiera', false, 20, 60),
                                                  ('Area Cipolla', true, 10, 50);

INSERT INTO misuratore(area_id,latitudine, longitudine,tipo) VALUES
                                                                (1, 302.15, 45.61, 'lampione'),
                                                                (1, 321.15, 85.61, 'lampione'),
                                                                (1, 332.15, 75.61, 'sensore'),
                                                                (1, 362.15, 55.61, 'sensore'),
                                                                (2, 292.15, 115.61, 'lampione'),
                                                                (2, 282.15, 135.61, 'lampione'),
                                                                (2, 402.15, 165.61, 'sensore'),
                                                                (2, 512.15, 175.61, 'sensore'),
                                                                (3, 243.15, 185.61, 'lampione'),
                                                                (3, 322.15, 195.61, 'lampione'),
                                                                (3, 262.15, 285.61, 'sensore'),
                                                                (3, 272.15, 315.61, 'sensore');

INSERT INTO sensore(misuratore_id,raggio) VALUES
                                             (3,45),
                                             (4,51),
                                             (7,32),
                                             (8,63),
                                             (11,84),
                                             (12,95);

INSERT INTO lampione(misuratore_id,wattaggio,luminosita) VALUES
                                                 (1,45,10),
                                                 (2,51,10),
                                                 (5,32,10),
                                                 (6,63,10),
                                                 (9,84,10),
                                                 (10,95,10);
