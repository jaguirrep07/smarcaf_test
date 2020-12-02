CREATE TABLE `client` (
  `id` int(11) NOT NULL ,
  `tipo_identificacion` varchar(255) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `matricula` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL
);

CREATE TABLE `employee` (
  `id` int(11) NOT NULL ,
  `tipo_identificacion` varchar(255) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `estado` varchar(255) NOT NULL
);

CREATE TABLE `assistance` (
  `id` int(11) NOT NULL ,
  `fecha_entrada` date NOT NULL,
  `hora` varchar(255) NOT NULL,
  `observacion` varchar(255) NOT NULL,
  `id_client` int(11) DEFAULT NULL
);

CREATE TABLE `physical_evaluation` (
  `id` int(11) NOT NULL ,
  `fecha_registro` date NOT NULL,
  `hora` varchar(255) NOT NULL,
  `lesiones_fisicas` varchar(255) NOT NULL,
  `consumo_medicamentos` varchar(255) NOT NULL,
  `consumo_sustancias_psicoactivas` varchar(255) NOT NULL,
  `horas_sueno` varchar(255) NOT NULL,
  `altura` varchar(255) NOT NULL,
  `peso` varchar(255) NOT NULL,
  `pulso` varchar(255) NOT NULL,
  `observacion` varchar(255) NOT NULL,
  `id_client` int(11) DEFAULT NULL
);

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `id_employee` int(11) DEFAULT NULL
);

ALTER TABLE `client`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `assistance`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CLIENT_ASSISTANCE` (`id_client`);

ALTER TABLE `physical_evaluation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CLIENT_PHYS_EVA` (`id_client`);

ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_EMPLOYEE_FOR_USER` (`id_employee`);

ALTER TABLE `client`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT; 

ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `assistance`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `physical_evaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `assistance`
  ADD CONSTRAINT `FK_CLIENT_ASSISTANCE` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);
  
ALTER TABLE `physical_evaluation`
  ADD CONSTRAINT `FK_CLIENT_PHYS_EVA` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`);  

ALTER TABLE `user`
  ADD CONSTRAINT `FK_EMPLOYEE_FOR_USER` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`id`); 