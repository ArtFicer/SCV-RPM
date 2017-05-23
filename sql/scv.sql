-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 23-Maio-2017 às 05:41
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scv`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `convidado`
--

CREATE TABLE `convidado` (
  `codConvidado` int(11) NOT NULL,
  `matricula_SIAPE` int(50) NOT NULL,
  `proposto_codProposto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `convidado`
--

INSERT INTO `convidado` (`codConvidado`, `matricula_SIAPE`, `proposto_codProposto`) VALUES
(1, 456128, 1),
(2, 2, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `codCurso` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `oferta_codOferta` int(11) NOT NULL,
  `trimestre_codTrimestre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`codCurso`, `nome`, `oferta_codOferta`, `trimestre_codTrimestre`) VALUES
(1, 'BSI', 1, 1),
(2, 'Esquerdismo', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `codDisciplina` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `trimestre_codTrimestre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`codDisciplina`, `nome`, `trimestre_codTrimestre`) VALUES
(1, 'LP1', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `oferta`
--

CREATE TABLE `oferta` (
  `codOferta` int(11) NOT NULL,
  `ano` int(50) NOT NULL,
  `polo_codPolo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `oferta`
--

INSERT INTO `oferta` (`codOferta`, `ano`, `polo_codPolo`) VALUES
(1, 2017, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `polo`
--

CREATE TABLE `polo` (
  `codPolo` int(11) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `logradouro` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `numero` int(50) NOT NULL,
  `telefone` int(50) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `polo`
--

INSERT INTO `polo` (`codPolo`, `cidade`, `logradouro`, `bairro`, `numero`, `telefone`, `email`) VALUES
(1, 'Juiz de Fora', '1', '1', 1, 1, '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `proposto`
--

CREATE TABLE `proposto` (
  `codProposto` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `setor` varchar(255) NOT NULL,
  `cpf` int(50) NOT NULL,
  `data_nascimento` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` int(50) NOT NULL,
  `celular` int(50) NOT NULL,
  `logradouro` varchar(255) NOT NULL,
  `numero` int(50) NOT NULL,
  `complemento` varchar(255) NOT NULL,
  `bairro` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `cep` int(50) NOT NULL,
  `titulacao_maxima` varchar(255) NOT NULL,
  `banco` varchar(255) NOT NULL,
  `agencia` int(50) NOT NULL,
  `conta` int(50) NOT NULL,
  `cargo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `proposto`
--

INSERT INTO `proposto` (`codProposto`, `nome`, `setor`, `cpf`, `data_nascimento`, `email`, `telefone`, `celular`, `logradouro`, `numero`, `complemento`, `bairro`, `cidade`, `uf`, `cep`, `titulacao_maxima`, `banco`, `agencia`, `conta`, `cargo`) VALUES
(1, 'zezinho', '1', 1, '1', '1', 1, 1, '1', 1, '1', '1', '1', '1', 1, '1', '1', 1, 1, '1'),
(2, 'joaozinho', '2', 2, '2', '2', 2, 2, '2', 2, '2', '2', '2', '2', 2, '2', '2', 2, 2, '2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `relatorioviagem`
--

CREATE TABLE `relatorioviagem` (
  `codRelatorioViagem` int(11) NOT NULL,
  `relatorio` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `relatorioviagem`
--

INSERT INTO `relatorioviagem` (`codRelatorioViagem`, `relatorio`) VALUES
(1, 'batata');

-- --------------------------------------------------------

--
-- Estrutura da tabela `secretaria`
--

CREATE TABLE `secretaria` (
  `codSecretaria` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `proposto_codProposto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `secretaria`
--

INSERT INTO `secretaria` (`codSecretaria`, `nome`, `email`, `senha`, `proposto_codProposto`) VALUES
(1, 'admin', 'admin@admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `servidor`
--

CREATE TABLE `servidor` (
  `codServidor` int(11) NOT NULL,
  `matricula_SIAPE` int(50) NOT NULL,
  `lotado_Orgao` varchar(255) NOT NULL,
  `proposto_codProposto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `servidor`
--

INSERT INTO `servidor` (`codServidor`, `matricula_SIAPE`, `lotado_Orgao`, `proposto_codProposto`) VALUES
(1, 1, '12', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `solicitacao`
--

CREATE TABLE `solicitacao` (
  `codSolicitacao` int(11) NOT NULL,
  `assunto` varchar(255) NOT NULL,
  `texto` varchar(255) NOT NULL,
  `proposto_codProposto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `solicitacao`
--

INSERT INTO `solicitacao` (`codSolicitacao`, `assunto`, `texto`, `proposto_codProposto`) VALUES
(1, '1', '12', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `transporte`
--

CREATE TABLE `transporte` (
  `codTransporte` int(11) NOT NULL,
  `empresa` varchar(255) NOT NULL,
  `veiculo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `transporte`
--

INSERT INTO `transporte` (`codTransporte`, `empresa`, `veiculo`) VALUES
(1, 'fulana', 'airbus');

-- --------------------------------------------------------

--
-- Estrutura da tabela `trimestre`
--

CREATE TABLE `trimestre` (
  `codTrimestre` int(11) NOT NULL,
  `numero_trimestre` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `trimestre`
--

INSERT INTO `trimestre` (`codTrimestre`, `numero_trimestre`) VALUES
(1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `viagem`
--

CREATE TABLE `viagem` (
  `codViagem` int(11) NOT NULL,
  `destino` varchar(45) NOT NULL,
  `data_viagem` varchar(45) NOT NULL,
  `horario_saida` varchar(45) NOT NULL,
  `status_confirmacao` varchar(45) NOT NULL,
  `status_conclusao` varchar(45) NOT NULL,
  `proposto_codProposto` int(11) NOT NULL,
  `relatorioviagem_codRelatorioViagem` int(11) NOT NULL,
  `polo_codPolo` int(11) NOT NULL,
  `transporte_codTransporte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `viagem`
--

INSERT INTO `viagem` (`codViagem`, `destino`, `data_viagem`, `horario_saida`, `status_confirmacao`, `status_conclusao`, `proposto_codProposto`, `relatorioviagem_codRelatorioViagem`, `polo_codPolo`, `transporte_codTransporte`) VALUES
(1, 'Cabo Frio', '22/05/2017', '20:00', 'Confirmada', 'Não Concluída', 1, 1, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `convidado`
--
ALTER TABLE `convidado`
  ADD PRIMARY KEY (`codConvidado`),
  ADD KEY `fk_convidado_proposto_idx` (`proposto_codProposto`);

--
-- Indexes for table `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`codCurso`),
  ADD KEY `fk_curso_oferta1_idx` (`oferta_codOferta`),
  ADD KEY `fk_curso_trimestre1_idx` (`trimestre_codTrimestre`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`codDisciplina`),
  ADD KEY `fk_disciplina_trimestre1_idx` (`trimestre_codTrimestre`);

--
-- Indexes for table `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`codOferta`),
  ADD KEY `fk_oferta_polo1_idx` (`polo_codPolo`);

--
-- Indexes for table `polo`
--
ALTER TABLE `polo`
  ADD PRIMARY KEY (`codPolo`);

--
-- Indexes for table `proposto`
--
ALTER TABLE `proposto`
  ADD PRIMARY KEY (`codProposto`);

--
-- Indexes for table `relatorioviagem`
--
ALTER TABLE `relatorioviagem`
  ADD PRIMARY KEY (`codRelatorioViagem`);

--
-- Indexes for table `secretaria`
--
ALTER TABLE `secretaria`
  ADD PRIMARY KEY (`codSecretaria`),
  ADD KEY `fk_secretaria_proposto1_idx` (`proposto_codProposto`);

--
-- Indexes for table `servidor`
--
ALTER TABLE `servidor`
  ADD PRIMARY KEY (`codServidor`),
  ADD KEY `fk_servidor_proposto1_idx` (`proposto_codProposto`);

--
-- Indexes for table `solicitacao`
--
ALTER TABLE `solicitacao`
  ADD PRIMARY KEY (`codSolicitacao`),
  ADD KEY `fk_solicitacao_proposto1_idx` (`proposto_codProposto`);

--
-- Indexes for table `transporte`
--
ALTER TABLE `transporte`
  ADD PRIMARY KEY (`codTransporte`);

--
-- Indexes for table `trimestre`
--
ALTER TABLE `trimestre`
  ADD PRIMARY KEY (`codTrimestre`);

--
-- Indexes for table `viagem`
--
ALTER TABLE `viagem`
  ADD PRIMARY KEY (`codViagem`),
  ADD KEY `fk_viagem_proposto1_idx` (`proposto_codProposto`),
  ADD KEY `fk_viagem_relatorioviagem1_idx` (`relatorioviagem_codRelatorioViagem`),
  ADD KEY `fk_viagem_polo1_idx` (`polo_codPolo`),
  ADD KEY `fk_viagem_transporte1_idx` (`transporte_codTransporte`);

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `convidado`
--
ALTER TABLE `convidado`
  ADD CONSTRAINT `fk_convidado_proposto` FOREIGN KEY (`proposto_codProposto`) REFERENCES `proposto` (`codProposto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `curso`
--
ALTER TABLE `curso`
  ADD CONSTRAINT `fk_curso_oferta1` FOREIGN KEY (`oferta_codOferta`) REFERENCES `oferta` (`codOferta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_curso_trimestre1` FOREIGN KEY (`trimestre_codTrimestre`) REFERENCES `trimestre` (`codTrimestre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD CONSTRAINT `fk_disciplina_trimestre1` FOREIGN KEY (`trimestre_codTrimestre`) REFERENCES `trimestre` (`codTrimestre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `fk_oferta_polo1` FOREIGN KEY (`polo_codPolo`) REFERENCES `polo` (`codPolo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `secretaria`
--
ALTER TABLE `secretaria`
  ADD CONSTRAINT `fk_secretaria_proposto1` FOREIGN KEY (`proposto_codProposto`) REFERENCES `proposto` (`codProposto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `servidor`
--
ALTER TABLE `servidor`
  ADD CONSTRAINT `fk_servidor_proposto1` FOREIGN KEY (`proposto_codProposto`) REFERENCES `proposto` (`codProposto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `solicitacao`
--
ALTER TABLE `solicitacao`
  ADD CONSTRAINT `fk_solicitacao_proposto1` FOREIGN KEY (`proposto_codProposto`) REFERENCES `proposto` (`codProposto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `viagem`
--
ALTER TABLE `viagem`
  ADD CONSTRAINT `fk_viagem_polo1` FOREIGN KEY (`polo_codPolo`) REFERENCES `polo` (`codPolo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_viagem_proposto1` FOREIGN KEY (`proposto_codProposto`) REFERENCES `proposto` (`codProposto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_viagem_relatorioviagem1` FOREIGN KEY (`relatorioviagem_codRelatorioViagem`) REFERENCES `relatorioviagem` (`codRelatorioViagem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_viagem_transporte1` FOREIGN KEY (`transporte_codTransporte`) REFERENCES `transporte` (`codTransporte`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
