import logging
import sys


def setup_logger():
    logger = logging.getLogger("selenium-ai-generator")
    logger.setLevel(logging.INFO)

    if not logger.handlers:
        handler = logging.StreamHandler(sys.stdout)

        formatter = logging.Formatter(
            "%(asctime)s | %(levelname)s | %(message)s",
            datefmt="%Y-%m-%d %H:%M:%S",
        )

        handler.setFormatter(formatter)
        logger.addHandler(handler)

    return logger


logger = setup_logger()