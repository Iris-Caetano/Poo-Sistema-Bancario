# Poo-Sistema-Bancario

## Atividade Desenvolvida

Este projeto implementa um módulo de movimentação de contas para a fintech fictícia Banco Digital Fácil, desenvolvido em Java. O objetivo é oferecer uma estrutura segura para operações bancárias, eliminando a possibilidade de alteração direta de saldo e centralizando as regras de negócio de cada tipo de conta em suas respectivas classes.

## O projeto contempla:

Uma classe abstrata ContaBancaria, responsável pelos dados e comportamentos comuns a toda conta;

Três tipos de conta especializados (ContaCorrente, ContaPoupanca e ContaEmpresarial), cada um com sua própria regra de saque;

Uma classe Main, que demonstra a criação de uma conta de cada tipo, depósitos, saques válidos e inválidos, uso do limite emergencial e cobrança da tarifa da conta empresarial.

Conceitos Aplicados

Herança: ContaCorrente, ContaPoupanca e ContaEmpresarial estendem ContaBancaria, reaproveitando atributos e comportamentos comuns (número da conta, titular, saldo, depósito e extrato).

Classes abstratas e métodos abstratos: ContaBancaria é abstrata e não pode ser instanciada diretamente; o método sacar() é declarado como abstrato, obrigando cada subclasse a implementar sua própria regra de saque.

Encapsulamento: o atributo saldo é privado e não possui método setSaldo(). Toda alteração de saldo ocorre exclusivamente por meio dos métodos depositar() (público, com validação) e debitar() (protegido), impedindo que o saldo seja modificado diretamente por classes externas, como a Main.

Modificador de acesso protected: o método debitar() é protegido, o que permite que apenas a própria classe e suas subclasses o utilizem para executar o débito após a validação do saque, sem expor esse controle à Main.

Polimorfismo: cada subclasse implementa sacar() de acordo com sua própria regra de negócio, sendo tratada de forma uniforme sempre que referenciada pelo tipo da superclasse ContaBancaria.

Validação de regras de negócio: valores de depósito e saque são validados antes de qualquer alteração de saldo, recusando operações inválidas (valores zero, negativos, ou que ultrapassem o saldo disponível somado ao limite).

##Solução Adotada

O saldo inicial de toda conta é fixado em zero diretamente no construtor da ContaBancaria, que não recebe esse valor como parâmetro tornando estruturalmente impossível criar uma conta com saldo inicial diferente de zero. Depósitos são validados no método depositar(), que só altera o saldo quando o valor informado é maior que zero.

Cada tipo de conta implementa sacar() de acordo com sua regra específica:

Conta Poupança: o saque só é aceito se o valor for maior que zero e não exceder o saldo disponível, garantindo que a conta nunca fique negativa.

Conta Corrente: o saque considera o saldo somado ao limite emergencial disponível (saldo + limite) como teto, permitindo que o saldo fique negativo até esse limite.

Conta Empresarial: além de considerar o limite disponível, o método soma uma taxa fixa de R$ 5,00 ao valor solicitado, tanto na validação do teto disponível quanto no débito efetivo, garantindo que a tarifa seja sempre cobrada junto ao saque.

Em todos os casos, a alteração real do saldo é feita por meio do método debitar(), herdado da superclasse. Como esse método é protected, apenas as próprias contas podem executá-lo e somente depois de suas respectivas validações, o que impede que o saldo seja alterado diretamente pela classe Main ou por qualquer código externo à hierarquia de contas.


Captura de tela do resultado no terminal:

<img width="650" height="515" alt="Captura de tela 2026-09-08 203237" src="https://github.com/user-attachments/assets/50fedd95-94d4-464d-978a-7956ec7c2b58" />

