# language: pt
Funcionalidade: Chegou a hora de poupar! Mas quanto? Em quanto tempo? Como posso saber?
  Nosso associado gostaria de simular o investimento na poupança para descobrir qual o
  valor ideal e quanto ele vai poupar no prazo que escolher.
  Vamos construir um simulador de investimentos?
  
  História
  Com o propósito de Simular um Investimento na Poupança
  como um Associado,
  eu gostaria de preencher o formulário de simulação
  e ver a tabela de resultado com Mês e Valor.
  
  Critérios de aceitação:	
  1. O associado preencher todos os campos corretamente e visualizar o formulário de
  simulação
  2. O associado preencher o valor inferior a “R$ 20.00” e receber a mensagem de
  orientação “Valor mínimo de R$ 20.00”.

  Cenário: Realizar o preenchimento de todos os campos corretamente
    Dado que realizei a seleção de uma das opções do perfil
    E realizei o preenchimento dos campos obrigatórios
    Quando executo o clique no botão simular
    Então é possivel visualizar o formulário de simulação

  Cenário: Não realizar o preenchimento dos campos obrigatórios
    Dado que realizei a seleção de uma das opções do perfil
    E não realizei o preenchimento dos campos obrigatórios
    Quando executo o clique no botão simular
    Então uma mensagem de aviso sobre a obrigatoriedade de preenchimento dos campos deve ser apresentada

  Cenário: Validar bloqueio de caracteres inválidos nos campos com valores
    Dado que realizei a seleção de uma das opções do perfil
    Quando realizo a tentativa de inserir caracteres não permitidos nos campos de tipo "VALOR"
    Então não deve ser permitido inserir estes tipos de caracteres nos campos de tipo "VALOR"

  Cenário: Validar bloqueio de caracteres inválidos no campo com tempo
    Dado que realizei a seleção de uma das opções do perfil
    Quando realizo a tentativa de inserir caracteres não permitidos nos campos de tipo "TEMPO"
    Então não deve ser permitido inserir estes tipos de caracteres nos campos de tipo "TEMPO"

  Esquema do Cenário: Validar dados de entrada específicos nos campos de valores
    Dado que realizei a seleção de uma das opções do perfil
    Quando inserir o dado de entrada da coluna "APLICAR" com o valor <aplicar>
    E inserir o dado de entrada da coluna "POUPAR" com o valor <poupar>
    Então é possivel visualizar o formulário de simulação

    Exemplos: 
      | aplicar | poupar |
      |   20.00 |  20.00 |
      |   20.01 |  20.01 |

  Esquema do Cenário: Validar dados de entrada específicos nos campos de valores
    Dado que realizei a seleção de uma das opções do perfil
    Quando inserir o dado de entrada da coluna "APLICAR" com o valor <aplicar>
    E inserir o dado de entrada da coluna "POUPAR" com o valor <poupar>
    Então não é possivel visualizar o formulário de simulação

    Exemplos: 
      | aplicar | poupar |
      |    0.00 |   0.00 |
      |   19.99 |  19.99 |
      |   20.00 |   0.00 |
      |    0.00 |  20.00 |

  Cenário: Validar botão REFAZER A SIMULAÇÃO
    Dado que realizei a seleção de uma das opções do perfil
    E realizei o preenchimento dos campos obrigatórios
    Quando executo o clique no botão simular
    Então é possivel visualizar o formulário de simulação
    E é possível realizar clique no botão refazer a simulação
