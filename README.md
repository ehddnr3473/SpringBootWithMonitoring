# SpringBootWithMonitoring

## Prometheus
**설정 파일과 함께 서버 실행**
```shell
./prometheus.exe --config.file=prometheus.yml
```

**설정 파일 Job 나누기**
```yml
scrape_configs:
  - job_name: "prometheus"

    static_configs:
      - targets: ["localhost:9090"]
        labels:
          app: "prometheus"

  - job_name: "monitoring"

    metrics_path: /actuator/prometheus

    static_configs:
      - targets: ["localhost:9000"]
```