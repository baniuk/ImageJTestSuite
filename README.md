[![Maven Central](https://img.shields.io/maven-central/v/com.github.baniuk/ImageJTestSuite.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.baniuk%22%20AND%20a%3A%22ImageJTestSuite%22)

# ImageJTestSuite

## Documentation
Maven generated site is available under [GitHub pages](https://baniuk.github.io/ImageJTestSuite)

## Build
```sh
# use Maven release plugin after proper configuration of settings.xml
# It is linked with sonatype profile
mvn release:clean release:prepare -DpushChanges=false
# push to repo
git push --tags
# perform release and deploy to ossrh
mvn release:perform
# update changelog
github_changelog_generator
git commit -am "Updated Changelog" -S
# push site to GH
cd target/checkout
mvn site-deploy
```

