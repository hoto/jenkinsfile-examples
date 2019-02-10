jsl = library(
  identifier: 'jenkins-shared-library@1.0.4',
  retriever: modernSCM(
    [
      $class: 'GitSCMSource',
      remote: 'https://github.com/hoto/jenkins-shared-library.git'
    ]
  )
)

simplePipeline([jsl: jsl])
  .build(
    command: 'My build command'
  )
  .unitTest(
    command: 'My unit test command'
  )
  .deploy(
    command: 'My deploy command'
  )

