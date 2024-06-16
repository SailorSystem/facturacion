 	/*==============================================================*/
/* Table: PRODUCTOS                                             */
/*==============================================================*/
create table PRODUCTOS (
   PROCODIGO            CHAR(9)              not null,
   PRODESCRIPCION       CHAR(50)             not null,
   PROUNIDADMEDIDA      CHAR(3)              not null,
   PROSALDOINICIAL      DECIMAL(9,2)         not null,
   PROINGRESOS          DECIMAL(9,2)         not null,
   PROEGRESOS           NUMERIC(9,2)         not null,
   PROAJUSTES           NUMERIC(9,2)         not null,
   PROSALDOFINAL        NUMERIC(9,2)         not null,
   PROCOSTOUM           NUMERIC(7,2)         not null,
   PROPRECIOUM          NUMERIC(7,2)         not null,
   PROSTATUS            CHAR(3)              not null,
   constraint PK_PRODUCTOS primary key (PROCODIGO)
);                                                                                                                                                                  /*==============================================================*/
/* Table: FACTURAS                                              */
/*==============================================================*/
CREATE TABLE FACTURAS (
   FACNUMERO            CHAR(9)              NOT NULL,
   CLICODIGO            CHAR(7)              NOT NULL,
   FACFECHA             DATE                 NOT NULL,
   FACSUBTOTAL          NUMERIC(9,2)         NOT NULL,
   FACDESCUENTO         NUMERIC(9,2)         NULL,
   FACIVA               NUMERIC(9,2)         NULL,
   FACICE               NUMERIC(9,2)         NULL,
   FACFORMAPAGO         CHAR(5)              NOT NULL,
   FACSTATUS            CHAR(3)              NOT NULL,
   CONSTRAINT PK_FACTURAS PRIMARY KEY (FACNUMERO),
   CONSTRAINT chk_facsubtotal_nonnegative CHECK (FACSUBTOTAL >= 0),
   CONSTRAINT chk_facdescuento_nonnegative CHECK (FACDESCUENTO >= 0),
   CONSTRAINT chk_faciva_nonnegative CHECK (FACIVA >= 0),
   CONSTRAINT chk_facice_nonnegative CHECK (FACICE >= 0),
   CONSTRAINT chk_facformapago_valid CHECK (FACFORMAPAGO IN ('EFECT', 'TARJE', 'TRNFE')),
   CONSTRAINT chk_facstatus_valid CHECK (FACSTATUS IN ('ACT', 'ANU', 'PRO'))
);

/*==============================================================*/
/* Table: PXF                                                   */
/*==============================================================*/
create table PXF (
   FACNUMERO            CHAR(9)              not null,
   PROCODIGO            CHAR(9)              not null,
   PXFCANTIDAD          NUMERIC(9,2)         not null,
   PXFVALOR             NUMERIC(7,2)         not null,
   PXFSUBTOTAL          NUMERIC(9,2)         not null,
   PXFSTATUS            CHAR(3)              not null,
   constraint PK_PXF primary key (FACNUMERO, PROCODIGO)
);                                                  
/*==============================================================*/
/* Table: CLIENTES                                              */
/*==============================================================*/
create table CLIENTES (
   CLICODIGO            CHAR(7)              not null,
   CLINOMBRE            CHAR(60)             not null,
   CLIIDENTIFICACION    CHAR(13)             not null,
   CLIDIRECCION         CHAR(60)             not null,
   CLITELEFONO          CHAR(10)             not null,
   CLICELULAR           CHAR(10)             not null,
   CLIEMAIL             CHAR(60)             null,
   CLITIPO              CHAR(3)              not null,
   CLISTATUS            CHAR(3)              not null,
   constraint PK_CLIENTES primary key (CLICODIGO)
);

insert into PRODUCTOS values ('P-0001', 'CEREAL TRIGO ENTERO',        'QQ ', 0, 0, 0, 0, 0, 1, 2, 'ACT');
insert into PRODUCTOS values ('P-0002', 'MORA FRUTO COMPLETO',        'CAJ', 0, 0, 0, 0, 0, 1, 2, 'ACT');
insert into PRODUCTOS values ('P-0003', 'CARNE DE CERDO CON HUESO',   'KG ', 0, 0, 0, 0, 0, 1, 2, 'ACT');
insert into PRODUCTOS values ('P-0004', 'SARDINAS EN CONSERVA',       'PAQ', 0, 0, 0, 0, 0, 1, 2, 'ACT');
insert into PRODUCTOS values ('P-0005', 'LECHE LÍQUIDA PASTEURIZADA', 'LIT', 0, 0, 0, 0, 0, 1, 2, 'ACT');
insert into PRODUCTOS values ('P-0006', 'ATÚN EN CONSERVA ',          'UNI', 0, 0, 0, 0, 0, 1, 2, 'ACT');

insert into CLIENTES values ('CLI-001', 'CORPORACION FAVORITA C.A.', '1702996501', 'Sangolquí Av. 6 de Diciembre y Julio Moreno Quito - Ecuador', '02-2996500', '0992996500', 'ventas@favorita.com.ec'      , 'JUR', 'ACT');
insert into CLIENTES values ('CLI-002', 'CÓNDOR JAVIER'            , '0702996502', 'Centro Av. 9 De Octubre 729 y Boyacá Guayaquil - Ecuador'   , '02-2980980', '0992996500', 'ventas@elrosado.com.ec'      , 'NAT', 'ACT');
insert into CLIENTES values ('CLI-003', 'INDUSTRIAL PESQUERA SANTA', '1402996503', 'Vía Daule Km 5 1/2 y Calle Sèptima Guayaquil - Ecuador'     , '04-2322000', '0992996500', 'ventas@santa_priscila.com.ec', 'JUR', 'ACT');
insert into CLIENTES values ('CLI-004', 'PAMELA CORTEZ'           , '0602996504', 'Norte Km. 16 1/2, vía a Daule, calle Cobre por Pascuales'   , '04-6005238', '0992996500', 'ventas@ecuacorriente.ec'     , 'NAT', 'ACT');
insert into CLIENTES values ('CLI-005', 'DINADEC S.A.'            , '1902996505', 'Norte Km. 16 1/2, vía a Daule, calle Cobre por Pascuales'   , '04-5004040', '0992996500', 'ventas@danec.ec'             , 'JUR', 'ACT');
insert into CLIENTES values ('CLI-006', 'VERONICA ANTONELA FRITZ' , '2102996506', 'Cdla. Santa Leonor, Mz. 6, solar 17 Guayaquil - Ecuador'    , '04-5004040', '0992996500', 'ventas@difare.com.ec'        , 'NAT', 'ACT');


insert into PXF values ('FAC-001', 'P-0001', 2, 3, 4, '  1');
insert into PXF values ('FAC-001', 'P-0002', 0, 4, 5, '  2');
insert into PXF values ('FAC-002', 'P-0003', 1, 5, 2, '  3');
insert into PXF values ('FAC-002', 'P-0004', 3, 1, 0, '  4');
insert into PXF values ('FAC-003', 'P-0005', 4, 0, 3, '   ');
insert into PXF values ('FAC-003', 'P-0006', 5, 2, 1, '  0');


insert into FACTURAS values ('FAC-001', 'CLI-001', '215-6-12', 4, 3, 5, 2, 'KUS0N', '  3');
insert into FACTURAS values ('FAC-002', 'CLI-001', '1-1-1', 3, 5, 1, 4, 'S6US3', '   ');
insert into FACTURAS values ('FAC-003', 'CLI-005', '1569-8-23', 2, 4, 3, 3, '07VBH', '  1');


REATE USER gerente WITH PASSWORD 'gerenteguapo123';
CREATE USER cajero WITH PASSWORD 'cajero123';


GRANT CONNECT ON DATABASE facturacionsql TO gerente;
GRANT USAGE ON SCHEMA public TO gerente;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO gerente;

GRANT CONNECT ON DATABASE facturacionsql TO cajero;
GRANT USAGE ON SCHEMA public TO cajero;
GRANT SELECT, INSERT ON ALL TABLES IN SCHEMA public TO cajero;
GRANT DELETE ON ALL TABLES IN SCHEMA public TO cajero;
GRANT UPDATE ON ALL TABLES IN SCHEMA public TO cajero;


-- Actualización de los registros para que cumplan con las restricciones
UPDATE FACTURAS
SET FACNUMERO = 'FAC-001', CLICODIGO = 'CLI-001', FACFECHA = '2021-06-12', FACSUBTOTAL = 4, FACDESCUENTO = 3, FACIVA = 5, FACICE = 2, FACFORMAPAGO = 'EFECT', FACSTATUS = 'ACT'
WHERE FACNUMERO = 'FAC-001';

UPDATE FACTURAS
SET FACNUMERO = 'FAC-002', CLICODIGO = 'CLI-001', FACFECHA = '2021-01-01', FACSUBTOTAL = 3, FACDESCUENTO = 5, FACIVA = 1, FACICE = 4, FACFORMAPAGO = 'TARJE', FACSTATUS = 'ANU'
WHERE FACNUMERO = 'FAC-002';

UPDATE FACTURAS
SET FACNUMERO = 'FAC-003', CLICODIGO = 'CLI-005', FACFECHA = '2023-08-23', FACSUBTOTAL = 2, FACDESCUENTO = 4, FACIVA = 3, FACICE = 3, FACFORMAPAGO = 'TRNFE', FACSTATUS = 'PRO'
WHERE FACNUMERO = 'FAC-003';



-- Modificar la restricción chk_cliemail_format para verificar que contiene el símbolo '@'
ALTER TABLE CLIENTES
ADD CONSTRAINT chk_cliemail_format CHECK (CLIEMAIL IS NULL OR POSITION('@' IN CLIEMAIL) > 0);

-- Modificar la restricción chk_cliidentificacion_format para verificar que tiene exactamente 10 dígitos
ALTER TABLE CLIENTES
ADD CONSTRAINT chk_cliidentificacion_format CHECK (CLIIDENTIFICACION ~ '^[0-9]{10}$');

-- Modificar la restricción chk_clicelular_format para verificar que tiene exactamente 10 dígitos
ALTER TABLE CLIENTES
ADD CONSTRAINT chk_clicelular_format CHECK (CLICELULAR ~ '^[0-9]{10}$');
