'use strict';
require('grunt');
require('mocha');

const config = {
  targets: {
    test: ['test/**/*.test.ts'],
    ts: ['src/**/*.ts', 'test/**/*.ts'],
  },
  timeout: 5000,
  require: ['ts-node/register', 'should'],
};
config.targets.all = config.targets.test.concat(config.targets.ts);

const tsConfig = {
  default: {
    options: {
      fast: 'always',
      verbose: true,
    },
    tsconfig: './tsconfig.json',
  },
};

const mochaConfig = {
  options: {
    reporter: 'spec',
    timeout: config.timeout,
    require: config.require,
  },
  src: config.targets.test,
};

const execConfig = {
  clean: 'rm -rf ./built && rm -rf .tscache',
  start: './node_modules/.bin/ts-node index.ts',
};

const eslintConfig = {
  options: {
    configFile: '.eslintrc.json',
  },
  target: ['src/**/*.ts'],
};

module.exports = function (grunt) {
  grunt.initConfig({
    eslint: eslintConfig,
    ts: tsConfig,
    exec: execConfig,
    mochaTest: mochaConfig,
    watch: {
      files: config.targets.all,
      tasks: ['default'],
    },
  });

  grunt.loadNpmTasks('grunt-mocha-test');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-env');
  grunt.loadNpmTasks('grunt-ts');
  grunt.loadNpmTasks('grunt-exec');
  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-eslint');

  // Default task.
  grunt.registerTask('lint', ['eslint']);
  grunt.registerTask('test', ['mochaTest']);
  grunt.registerTask('build', ['exec:clean', 'ts']);
  grunt.registerTask('default', ['test']);
};
